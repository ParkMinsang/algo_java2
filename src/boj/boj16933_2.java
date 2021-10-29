package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16933_2 {
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int[][][][] visit = new int[n][m][k+1][2];
        visit[0][0][0][0]=1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0,0,1));
        int ans = -1;
        while(!q.isEmpty()){
            Point curr = q.poll();
            int r=curr.r, c=curr.c, cnt=curr.cnt, night=curr.night, dist=curr.dist;
            if(r==n-1 && c==m-1){
                if(ans==-1) ans=dist;
                else ans=Math.min(ans, dist);
                continue;
            }
            if(visit[r][c][cnt][night]<dist) {
                continue;
            }

            for(int d=0; d<4; d++){
                int nr=r+dr[d];
                int nc=c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(map[nr][nc]==0){
                    if(visit[nr][nc][cnt][night^1]!=0 && visit[nr][nc][cnt][night^1]<=dist+1) continue;
                    visit[nr][nc][cnt][night^1]=dist+1;
                    q.add(new Point(nr, nc, cnt, night^1, dist+1));
                }else{
                    if(cnt>=k) continue;
                    if(night==0){
                        if(visit[nr][nc][cnt+1][night^1]!=0 && visit[nr][nc][cnt+1][night^1]<=dist+1) continue;
                        visit[nr][nc][cnt+1][night^1]=dist+1;
                        q.add(new Point(nr, nc, cnt+1, night^1, dist+1));
                    }
                    else{
                        if(visit[nr][nc][cnt+1][night]!=0 && visit[nr][nc][cnt+1][night]<=dist+2) continue;
                        visit[nr][nc][cnt+1][night]=dist+2;
                        q.add(new Point(nr, nc, cnt+1, night, dist+2));
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Point{
        int r, c, cnt, night, dist;

        Point(int r, int c, int cnt, int night, int dist){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
            this.night=night;
            this.dist=dist;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    ", night=" + night +
                    ", dist=" + dist +
                    '}';
        }
    }
}
