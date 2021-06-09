package boj;

import java.io.*;
import java.util.*;

public class boj16954 {
    static boolean[][] isVisited;
    static int[] dr={-1,-1,-1,0,0,0,1,1,1}, dc={-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[8][8];
        String inputline=null;
        for(int i=0; i<8; i++){
            inputline = br.readLine();
            for(int j=0; j<8; j++){
                map[i][j] = inputline.charAt(j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(7,0));
        boolean flag=false;
        int nr=0, nc=0, size=0;
        isVisited = new boolean[8][8];

        while(!q.isEmpty() && !flag){
            size = q.size();
            for(int i=0; i<8; i++) Arrays.fill(isVisited[i], false);
            for(int i=0; i<size; i++){
                Point p = q.poll();
                if(p.r==0 && p.c==7){
                    flag=true;
                    break;
                }
                if(map[p.r][p.c]=='#') continue;
                for(int d=0; d<9; d++){
                    nr = p.r+dr[d];
                    nc = p.c+dc[d];
                    if(nr<0 || nr>=8 || nc<0 || nc>=8 || map[nr][nc]=='#' || isVisited[nr][nc]) continue;
                    isVisited[nr][nc]=true;
                    q.add(new Point(nr,nc));
                }
            }
            if(flag) break;

            for(int i=7; i>=0; i--){
                for(int j=0; j<8; j++){
                    if(map[i][j] == '#'){
                        map[i][j]='.';
                        if(i!=7) map[i+1][j]='#';
                    }
                }
            }
        }
        System.out.println(flag?1:0);
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
