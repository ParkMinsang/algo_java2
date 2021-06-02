package boj;

import java.io.*;
import java.util.*;

public class boj1261_2 {
    static final int INF = 99999;
    static int M,N;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    static int[][] map, dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            String mapline = br.readLine();
            Arrays.fill(dist[i], INF);
            for(int j=0; j<M; j++){
                if(mapline.charAt(j) == '1')
                    map[i][j] = -1; // 벽을 -1로 표기
            }
        }
        dist[0][0]=0;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        while(!q.isEmpty()){
            Point curr = q.poll();
            int nr=0,nc=0;

            for(int d=0; d<4; d++){
                nr = curr.r+dr[d];
                nc = curr.c+dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    if(map[nr][nc]==-1){
                        if(dist[nr][nc] > dist[curr.r][curr.c]+1){
                            dist[nr][nc] = dist[curr.r][curr.c]+1;
                            q.offer(new Point(nr,nc));
                        }
                    }
                    else if(map[nr][nc] != -1){
                        if(dist[nr][nc] > dist[curr.r][curr.c]){
                            dist[nr][nc] = dist[curr.r][curr.c];
                            q.offer(new Point(nr,nc));
                        }
                    }
                }
            }
        }

        System.out.println(dist[N-1][M-1]);

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
