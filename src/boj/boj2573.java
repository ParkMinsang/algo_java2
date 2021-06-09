package boj;

import java.io.*;
import java.util.*;

public class boj2573 {
    static int n,m;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][] map, tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        tmp = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = map[i][j];
            }
        }
        int ans=0, nr=0, nc=0;
        while(!isEmpty() && cntIsland()<2){
            ans++;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != 0){
                        for(int d=0; d<4; d++){
                            nr = i+dr[d];
                            nc = j+dc[d];
                            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                            if(map[nr][nc]==0) tmp[i][j]--;
                            if(tmp[i][j]<0) tmp[i][j]=0;
                        }
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    map[i][j] = tmp[i][j];
                }
            }

        }

        if(cntIsland()<2){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }
    }

    static int cntIsland(){
        boolean[][] isVisited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        int ret=0, nr=0, nc=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] > 0 && !isVisited[i][j]){
                    isVisited[i][j]=true;
                    q.add(new Point(i,j));
                    ret++;
                }
                while(!q.isEmpty()){
                    Point curr = q.poll();
                    for(int d=0; d<4; d++){
                        nr = curr.r+dr[d];
                        nc = curr.c+dc[d];

                        if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                        if(!isVisited[nr][nc] && map[nr][nc]>0){
                            isVisited[nr][nc]=true;
                            q.add(new Point(nr,nc));
                        }
                    }
                }
            }
        }

        return ret;
    }

    static boolean isEmpty(){
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(map[r][c]>0) return false;
            }
        }
        return true;
    }

    static class Point{
        int r,c;
        Point(int r, int c){
            super();
            this.r=r;
            this.c=c;
        }
    }
}
