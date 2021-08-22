package boj;

import java.io.*;
import java.util.*;

public class boj4963 {
    static int w,h;
    static int[] dr = {-1,-1,-1,0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,1,-1,0,1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true) {
            st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            map = new int[h][w];
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(cnt());
        }
    }
    static int cnt() {
        int ans=0;
        boolean[][] isVisited = new boolean[h][w];
        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    ans++;
                    isVisited[i][j] = true;
                    q.offer(new Point(i,j));
                    while(!q.isEmpty()) {
                        Point curr = q.poll();
                        int nr=0,nc=0;
                        for(int d=0; d<8; d++) {
                            nr = curr.r+dr[d];
                            nc = curr.c+dc[d];

                            if(nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc]==1 && !isVisited[nr][nc]) {
                                isVisited[nr][nc] = true;
                                q.offer(new Point(nr, nc));
                            }
                        }
                    }

                }
            }
        }

        return ans;
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