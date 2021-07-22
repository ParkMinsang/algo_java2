package boj;

import java.io.*;
import java.util.*;

public class boj4485 {
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc=0;

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            tc++;

            int[][] map = new int[n][n];
            boolean[][] isVisited = new boolean[n][n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(new Point(0,0), new Point(0,1),map[0][0]+map[0][1]));
            pq.add(new Edge(new Point(0,0), new Point(1,0),map[0][0]+map[1][0]));
            isVisited[0][0]=true;

            while(!isVisited[n-1][n-1] && !pq.isEmpty()){
                Edge curr = pq.poll();
                Point to = curr.to;
                if(to.r==n-1 && to.c==n-1){
                    sb.append("Problem ").append(tc).append(": ").append(curr.w).append('\n');
                    break;
                }
                if(isVisited[to.r][to.c]) continue;
                Point fr = curr.from;
                isVisited[to.r][to.c]=true;

                for(int d=0; d<4; d++){
                    int nr=to.r+dr[d];
                    int nc=to.c+dc[d];

                    if(nr<0 || nr>=n || nc<0 || nc>=n || isVisited[nr][nc]) continue;
                    pq.add(new Edge(new Point(to.r, to.c), new Point(nr,nc), curr.w+map[nr][nc]));
                }

            }

        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge>{
        Point from, to;
        int w;
        Edge(Point from, Point to, int w){
            this.from=from;
            this.to=to;
            this.w=w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }

    static class Point{
        int r,c;
        Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
