package boj;

import java.io.*;
import java.util.*;

public class boj16235_2 {
    static int[] dr={-1,-1,-1,0,0,1,1,1}, dc={-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][n];
        int[][] A = new int[n][n];
        PriorityQueue<Integer>[][] pq = new PriorityQueue[n][n];
        PriorityQueue<Integer>[][] tmppq = new PriorityQueue[n][n];
        Queue<Integer>[][] q = new LinkedList[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(land[i],5);
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                pq[i][j] = new PriorityQueue<>();
                tmppq[i][j] = new PriorityQueue<>();
                q[i][j] = new LinkedList<>();
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            pq[r][c].add(age);
        }

        for(int t=0; t<k; t++){
            //spring
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    while(!pq[i][j].isEmpty()){
                        int age = pq[i][j].poll();
                        if(land[i][j] >= age){
                            land[i][j] -= age;
                            tmppq[i][j].add(age+1);
                        }else{
                            q[i][j].add(age);
                        }
                    }
                }
            }

            //summer
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    while(!q[i][j].isEmpty()){
                        int age = q[i][j].poll();
                        land[i][j] += age/2;
                    }
                }
            }

            //fall
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    while(!tmppq[i][j].isEmpty()){
                        int tree = tmppq[i][j].poll();
                        if(tree%5==0){
                            for(int d=0; d<8; d++){
                                int nr=i+dr[d];
                                int nc=j+dc[d];

                                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                                pq[nr][nc].add(1);
                            }
                        }
                        pq[i][j].add(tree);
                    }
                }
            }

            //winter
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    land[i][j] += A[i][j];
                }
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans+=pq[i][j].size();
            }
        }
        System.out.println(ans);
    }

}
