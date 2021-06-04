package boj;

import java.io.*;
import java.util.*;

public class boj21922 {
    static int n,m;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};
    static int[][] map;
    static boolean[][] isCool;
    static boolean[][][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isCool = new boolean[n][m];
        isVisited = new boolean[n][m][4];

        ArrayList<Point> aircons = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    aircons.add(new Point(i,j));
                }
            }
        }

        int nr=0,nc=0;
        Queue<Wind> q;
        for(Point aircon : aircons){
            q = new LinkedList<>();
            for(int d=0; d<4; d++){
                if(!isVisited[aircon.r][aircon.c][d]){
                    q.add(new Wind(aircon.r, aircon.c, d));
                }
            }
            while(!q.isEmpty()){
                Wind w = q.poll();
                isCool[w.r][w.c] = true;
                if(w.d==0){
                    nr = w.r-1; nc=w.c;
                    if(nr>=0){
                        if((map[nr][nc]==0 || map[nr][nc]==1) && !isVisited[nr][nc][w.d]){
                            isVisited[nr][nc][w.d]=true;
                            q.add(new Wind(nr,nc,w.d));
                        }else if(map[nr][nc]==2){
                            isCool[nr][nc]=true;
                        }else if(map[nr][nc]==3 && !isVisited[nr][nc][1]){
                            isVisited[nr][nc][1]=true;
                            q.add(new Wind(nr,nc,1));
                        }else if(map[nr][nc]==4 && !isVisited[nr][nc][3]){
                            isVisited[nr][nc][3]=true;
                            q.add(new Wind(nr,nc,3));
                        }
                    }
                }
                else if(w.d==1){
                    nr=w.r; nc=w.c+1;
                    if(nc<m){
                        if((map[nr][nc]==0 || map[nr][nc]==2) && !isVisited[nr][nc][w.d]){
                            isVisited[nr][nc][w.d]=true;
                            q.add(new Wind(nr,nc,w.d));
                        }else if(map[nr][nc]==1){
                            isCool[nr][nc]=true;
                        }else if(map[nr][nc]==3 && !isVisited[nr][nc][0]){
                            isVisited[nr][nc][0]=true;
                            q.add(new Wind(nr,nc,0));
                        }else if(map[nr][nc]==4 && !isVisited[nr][nc][2]){
                            isVisited[nr][nc][2]=true;
                            q.add(new Wind(nr,nc,2));
                        }
                    }
                }
                else if(w.d==2){
                    nr=w.r+1; nc=w.c;
                    if(nr<n){
                        if((map[nr][nc]==0 || map[nr][nc]==1) && !isVisited[nr][nc][w.d]){
                            isVisited[nr][nc][w.d]=true;
                            q.add(new Wind(nr,nc,w.d));
                        }else if(map[nr][nc]==2){
                            isCool[nr][nc]=true;
                        }else if(map[nr][nc]==3 && !isVisited[nr][nc][3]){
                            isVisited[nr][nc][3]=true;
                            q.add(new Wind(nr,nc,3));
                        }else if(map[nr][nc]==4 && !isVisited[nr][nc][1]){
                            isVisited[nr][nc][1]=true;
                            q.add(new Wind(nr,nc,1));
                        }
                    }
                }
                else if(w.d==3){
                    nr=w.r; nc=w.c-1;
                    if(nc>=0){
                        if((map[nr][nc]==0 || map[nr][nc]==2) && !isVisited[nr][nc][w.d]){
                            isVisited[nr][nc][w.d]=true;
                            q.add(new Wind(nr,nc,w.d));
                        }else if(map[nr][nc]==1){
                            isCool[nr][nc]=true;
                        }else if(map[nr][nc]==3 && !isVisited[nr][nc][2]){
                            isVisited[nr][nc][2]=true;
                            q.add(new Wind(nr,nc,2));
                        }else if(map[nr][nc]==4 && !isVisited[nr][nc][0]){
                            isVisited[nr][nc][0]=true;
                            q.add(new Wind(nr,nc,0));
                        }
                    }
                }

            }
        }

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isCool[i][j]) ans++;
            }
        }
        System.out.println(ans);


    }
    public static class Wind{
        int r,c,d;
        Wind(int r, int c, int d){
            super();
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public static class Point{
        int r,c;
        Point(int r, int c){
            super();
            this.r=r;
            this.c=c;
        }
    }
}
