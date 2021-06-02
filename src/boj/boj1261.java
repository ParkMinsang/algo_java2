package boj;

import java.io.*;
import java.util.*;
// FAIL CODE
public class boj1261 {
    static int M,N;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            String mapline = br.readLine();
            for(int j=0; j<M; j++){
                if(mapline.charAt(j) == '1')
                    map[i][j] = -1; // 벽을 -1로 표기
            }
        }

        boolean[][] isVisited = new boolean[N][M];
        Queue<Point> q = null;
        int roomNum=-1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != -1 && !isVisited[i][j]){
                    roomNum++;
                    isVisited[i][j] = true;

                    q = new LinkedList<>();
                    q.offer(new Point(i,j));
                    while(!q.isEmpty()){
                        Point curr = q.poll();
                        map[curr.r][curr.c] = roomNum;

                        for(int d=0; d<4; d++){
                            int nr = curr.r+dr[d], nc = curr.c+dc[d];
                            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != -1 && !isVisited[nr][nc]){
                                isVisited[nr][nc] = true;
                                q.offer(new Point(nr, nc));
                            }
                        }
                    }
                }
            }
        }

        if(map[0][0] == map[N-1][M-1]){
            System.out.println(0);
            System.exit(0);
        }

        boolean[] isChecked = new boolean[roomNum+1];
        int[][] adj = new int[roomNum+1][roomNum+1];
        Queue<Point>[] queues = new Queue[roomNum+1];
        for(int i=0; i<roomNum+1; i++) queues[i] = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != -1){
                    queues[map[i][j]].offer(new Point(i,j));
                }
            }
        }

        for(int i=0; i<roomNum+1; i++){
            isVisited = new boolean[N][M];
            int size=0;
            int dist=0;
            while(!queues[i].isEmpty()){
                size = queues[i].size();
                dist++;
                for(int k=0; k<size; k++){
                    Point curr = queues[i].poll();

                    for(int d=0; d<4; d++){
                        int nr=curr.r+dr[d], nc=curr.c+dc[d];

                        if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != i && !isVisited[nr][nc]){
                            if(map[nr][nc] != -1 && map[nr][nc] != i && adj[i][map[nr][nc]] == 0){
                                adj[i][map[nr][nc]] = dist-1;
                            }
                            isVisited[nr][nc] = true;
                            queues[i].offer(new Point(nr,nc));
                        }
                    }
                }
            }
        }

        int[] dist = adj[0];
        boolean[] isVisit = new boolean[roomNum+1];
        isVisit[0] = true;
        while(!isVisit[map[N-1][M-1]]){
            int minVal=9999, minIdx=0;
            for(int i=0; i<roomNum+1; i++){
                if(!isVisit[i] && minVal > dist[i]){
                    minVal = dist[i];
                    minIdx = i;
                }
            }

            isVisit[minIdx] = true;
            if(isVisit[map[N-1][M-1]]) break;

            for(int i=0; i<roomNum+1; i++){
                dist[i] = Math.min(dist[i], dist[minIdx]+adj[minIdx][i]);
            }
        }
        System.out.println(dist[map[N-1][M-1]]);

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
