package boj;

import java.io.*;
import java.util.*;

public class boj14442 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N=0,M=0,K=0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dr={-1,0,1,0}, dc={0,-1,0,1};
        int[][] map = new int[N][M];
        boolean[][][] isVisited = new boolean[N][M][K+1];
        String inputline = null;
        for(int i=0; i<N; i++){
            inputline = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = inputline.charAt(j)-'0';
            }
        }

        int dist=0, size=0, nr=0, nc=0;
        boolean flag=false;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0));
        while(!q.isEmpty() && !flag){
            dist++;
            size = q.size();
            for(int i=0; i<size; i++){
                Point p = q.poll();
                if(p.r==N-1 && p.c==M-1){
                    flag=true;
                    break;
                }
                for(int d=0; d<4; d++){
                    nr = p.r+dr[d];
                    nc = p.c+dc[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                    if(map[nr][nc]==0 && !isVisited[nr][nc][p.k]){
                        isVisited[nr][nc][p.k] = true;
                        q.add(new Point(nr,nc,p.k));
                    }else if(map[nr][nc]==1 && p.k<K && !isVisited[nr][nc][p.k+1]){
                        isVisited[nr][nc][p.k+1]=true;
                        q.add(new Point(nr,nc,p.k+1));
                    }
                }
            }
        }
        System.out.println(flag?dist:-1);


    }

    static class Point{
        int r,c,k;
        Point(int r, int c, int k){
            super();
            this.r=r;
            this.c=c;
            this.k=k;
        }
    }
}
