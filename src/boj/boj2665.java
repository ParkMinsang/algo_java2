package boj;

import java.io.*;
import java.util.*;

public class boj2665 {
    static final int INF = 9999;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));
        int ans=0;

        while(!isVisited[n-1][n-1] && !pq.isEmpty()){
            Point curr = pq.poll();

            for(int d=0; d<4; d++){
                int nr=curr.r+dr[d];
                int nc=curr.c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=n || isVisited[nr][nc]) continue;
                isVisited[nr][nc]=true;
                int nd=curr.d+(map[nr][nc]==1?0:1);
                pq.add(new Point(nr,nc,nd));

                if(nr==n-1 && nc==n-1) ans=nd;
            }
        }
        System.out.println(ans);
    }
    static class Point implements Comparable<Point>{
        int r,c,d;
        Point(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }

        @Override
        public int compareTo(Point o){
            return Integer.compare(this.d, o.d);
        }
    }
}
