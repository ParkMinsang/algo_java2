package boj;

import java.io.*;
import java.util.*;

public class boj4991 {
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int h=0,w=0,cntDust=0, sr=0,sc=0,nr=0,nc=0;
        int[][] map;
        String inputline=null;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if((w|h) == 0) break;
            cntDust=0;
            map = new int[h][w];
            for(int i=0; i<h; i++){
                inputline = br.readLine();
                for(int j=0; j<w; j++){
                    char tmp = inputline.charAt(j);
                    if(tmp=='o'){
                        map[i][j]=-1;
                        sr = i; sc = j;
                    }else if(tmp=='*'){
                        map[i][j]=cntDust++;
                    }else if(tmp=='.'){
                        map[i][j]=-1;
                    }else{
                        map[i][j]=-2;
                    }
                }
            }

            boolean[][][] isVisited = new boolean[h][w][1<<cntDust];
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(sr, sc, 0));
            boolean flag=false;
            int dist=0, size=0;
            while(!q.isEmpty() && cntDust>0 && !flag){
                dist++;
                size = q.size();
                for(int i=0; i<size; i++){
                    Point p = q.poll();
                    if(p.dust == (1<<cntDust)-1){
                        flag=true;
                        break;
                    }
                    for(int d=0; d<4; d++){
                        nr = p.r+dr[d];
                        nc = p.c+dc[d];
                        if(nr<0 || nr>=h || nc<0 || nc>=w || map[nr][nc]==-2 || isVisited[nr][nc][p.dust]) continue;
                        isVisited[nr][nc][p.dust]=true;
                        if(map[nr][nc]>=0){
                            q.add(new Point(nr,nc,p.dust | (1<<map[nr][nc])));
                        }else{
                            q.add(new Point(nr,nc,p.dust));
                        }
                    }
                }
            }
            System.out.println(flag?dist-1:-1);

        }
    }
    static class Point{
        int r,c, dust;
        Point(int r, int c, int dust){
            super();
            this.r=r;
            this.c=c;
            this.dust=dust;
        }
    }
}
