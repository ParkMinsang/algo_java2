package boj;

import java.io.*;
import java.util.*;

public class boj2589 {
    static int w,h, ans;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        for(int i=0; i<h; i++){
            String mapline = br.readLine();
            for(int j=0; j<w; j++){
                map[i][j] = mapline.charAt(j);
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == 'L'){
                    ans = Math.max(ans, getLongestDist(new Point(i, j)));
                }
            }
        }

        System.out.println(ans);
    }

    public static int getLongestDist(Point p){
        int dist=-1;
        boolean[][] isVisited = new boolean[h][w];
        isVisited[p.r][p.c] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(p);

        int size=0,nr=0,nc=0;
        while(!q.isEmpty()){
            size = q.size();
            dist++;
            for(int i=0; i<size; i++){
                Point curr = q.poll();

                for(int d=0; d<4; d++){
                    nr = curr.r+dr[d];
                    nc = curr.c+dc[d];

                    if(nr>=0 && nr<h && nc>=0 && nc<w && map[nr][nc]=='L' && !isVisited[nr][nc]){
                        isVisited[nr][nc] = true;
                        q.offer(new Point(nr, nc));
                    }
                }
            }
        }

        return dist;
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
