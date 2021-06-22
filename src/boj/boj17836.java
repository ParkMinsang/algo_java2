package boj;

import java.io.*;
import java.util.*;

public class boj17836 {
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][] isVisited = new boolean[n][m][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0));

        int size=0;
        for(int t=0; t<=T; t++){
            size = q.size();
            if(size==0) break;
            for(int k=0; k<size; k++){
                Point curr = q.poll();
                if(curr.r==n-1 && curr.c==m-1){
                    System.out.println(t);
                    System.exit(0);
                }
                if(map[curr.r][curr.c]==2) curr.s=1;

                int nr=0, nc=0;
                for(int d=0; d<4; d++){
                    nr = curr.r+dr[d];
                    nc = curr.c+dc[d];

                    if(nr<0 || nr>=n || nc<0 || nc>=m || isVisited[nr][nc][curr.s] || (curr.s==0 && map[nr][nc]==1)) continue;
                    isVisited[nr][nc][curr.s]=true;
                    q.add(new Point(nr,nc,curr.s));
                }
            }
        }
        System.out.println("Fail");
    }

    static class Point{
        int r,c,s;
        Point(int r, int c, int s){
            this.r=r;
            this.c=c;
            this.s=s;
        }
    }
}
