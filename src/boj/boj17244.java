package boj;

import java.io.*;
import java.util.*;

public class boj17244 {
    static int n,m;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int sr=0, sc=0, cntObj=0;
        int[][] map = new int[n][m];
        String inputline = null;
        for(int i=0; i<n; i++){
            inputline = br.readLine();
            for(int j=0; j<m; j++){
                char c = inputline.charAt(j);
                if(c=='#'){ // 못감
                    map[i][j] = -2;
                }else if(c=='.'){ // 감
                    map[i][j] = -1;
                }else if(c=='S'){ // 출발지
                    map[i][j] = -1;
                    sr = i;
                    sc = j;
                }else if(c=='E'){ // 목적지
                    map[i][j] = -3;
                }else if(c=='X'){
                    map[i][j] = cntObj++;
                }
            }
        }
        boolean[][][] isVisited = new boolean[n][m][1<<cntObj];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr,sc,0));
        int size=0, dist=0, nr=0, nc=0;
        while(!q.isEmpty()){
            dist++;
            size=q.size();
            for(int i=0; i<size; i++){
                Point p = q.poll();
                if(map[p.r][p.c]==-3 && p.obj==(1<<cntObj)-1){
                    System.out.println(dist-1);
                    System.exit(0);
                }
                for(int d=0; d<4; d++){
                    nr = p.r+dr[d];
                    nc = p.c+dc[d];
                    if(nr<0 || nr>=n || nc<0 || nc>=m || map[nr][nc]==-2 || isVisited[nr][nc][p.obj]) continue;
                    isVisited[nr][nc][p.obj]=true;
                    if(map[nr][nc]>=0){
                        q.add(new Point(nr,nc, p.obj | (1<<map[nr][nc])));
                    }else{
                        q.add(new Point(nr,nc,p.obj));
                    }
                }
            }
        }

    }
    static class Point{
        int r,c,obj;
        Point(int r, int c, int obj){
            super();
            this.r=r;
            this.c=c;
            this.obj=obj;
        }
    }
}
