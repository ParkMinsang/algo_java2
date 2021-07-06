package boj;

import java.io.*;
import java.util.*;

public class boj18128 {
    static int n;
    static int[][] map, con, time;
    static int[] dr={-1,0,1,0,-1,-1,1,1}, dc={0,-1,0,1,-1,1,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        con = new int[n][n];
        time = new int[n][n];

        for(int i=0; i<n; i++) Arrays.fill(time[i], -1);

        Queue<Point> wq = new LinkedList<>();
        for(int i=0; i<w; i++){
            st = new StringTokenizer(br.readLine()," ");
            int wr = Integer.parseInt(st.nextToken())-1;
            int wc = Integer.parseInt(st.nextToken())-1;
            time[wr][wc]=0;
            wq.add(new Point(wr,wc));
        }

        for(int i=0; i<n; i++){
            String inputline = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = inputline.charAt(j)-'0';
            }
        }

        int size=0, t=0;
        while(!wq.isEmpty()){
            t++;
            size = wq.size();
            for(int i=0; i<size; i++){
                Point curr = wq.poll();

                for(int d=0; d<4; d++){
                    int nr = curr.r+dr[d];
                    int nc = curr.c+dc[d];

                    if(nr<0 || nr>=n || nc<0 || nc>=n || time[nr][nc]!=-1) continue;

                    time[nr][nc]=t;
                    wq.add(new Point(nr,nc));
                }
            }
        }
        time[n-1][n-1]=0;

        con[0][0]=1;
        Queue<Point> qq = new LinkedList<>();
        qq.add(new Point(0,0));

        while(!qq.isEmpty()){
            Point curr = qq.poll();

            for(int d=0; d<8; d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=n || map[nr][nc]!=1 || con[nr][nc]==1) continue;
                con[nr][nc]=1;
                qq.add(new Point(nr,nc));
            }
        }
        if(con[n-1][n-1]==0){
            System.out.println(-1);
            System.exit(0);
        }

        int lt=0, rt=1000000, mt=0, ans=0;
        while(lt<=rt){
            mt=(lt+rt)/2;
            if(isPos(mt)){
                ans=mt;
                rt=mt-1;
            }else{
                lt=mt+1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPos(int mt){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        boolean[][] isVisited = new boolean[n][n];
        isVisited[0][0]=true;

        while(!q.isEmpty()){
            Point curr = q.poll();
            if(curr.r==n-1 && curr.c==n-1) return true;

            for(int d=0; d<8; d++){
                int nr=curr.r+dr[d];
                int nc=curr.c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=n || map[nr][nc]==0 || isVisited[nr][nc] || time[nr][nc]>mt) continue;

                isVisited[nr][nc]=true;
                q.add(new Point(nr,nc));
            }
        }
        return false;
    }

    static class Point{
        int r,c;
        Point(int r,int c) {
            super();
            this.r=r;
            this.c=c;
        }
    }
}
