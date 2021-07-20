package boj;

import java.io.*;
import java.util.*;

public class boj7569 {
    static int[] dr={-1,0,1,0,0,0}, dc={0,-1,0,1,0,0}, dh={0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomatos = new int[n][m][h];

        Queue<Point> q = new LinkedList<>();
        int tot_tomatos=0, good_tomatos=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine()," ");

                for(int k=0; k<m; k++){
                    tomatos[j][k][i]=Integer.parseInt(st.nextToken());
                    if(tomatos[j][k][i]==1 || tomatos[j][k][i]==0) tot_tomatos++;
                    if(tomatos[j][k][i]==1) {
                        good_tomatos++;
                        q.add(new Point(j,k,i));
                    }
                }
            }
        }

        int size=0, time=0;
        while(!q.isEmpty() && good_tomatos!=tot_tomatos){
            time++;
            size = q.size();
            for(int k=0; k<size; k++){
                Point curr = q.poll();

                for(int d=0; d<6; d++){
                    int nr=curr.r+dr[d];
                    int nc=curr.c+dc[d];
                    int nh=curr.h+dh[d];

                    if(nr<0||nr>=n ||nc<0||nc>=m ||nh<0|nh>=h) continue;
                    if(tomatos[nr][nc][nh]==0){
                        tomatos[nr][nc][nh]=1;
                        good_tomatos++;
                        q.add(new Point(nr,nc,nh));
                    }
                }
            }
        }
        System.out.println(good_tomatos==tot_tomatos?time:-1);
    }

    static class Point{
        int r,c,h;
        Point(int r, int c, int h){
            this.r=r;
            this.c=c;
            this.h=h;
        }
    }
}
