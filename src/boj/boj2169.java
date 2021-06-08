package boj;

import java.io.*;
import java.util.*;

public class boj2169 {
    static final int INF = 99999999;
    static int N,M;
    static int[][] map;
    static int[][][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Arrays.fill(dp[i][j], -100000001);
            }
        }

        System.out.println(func(0,0,0));
    }
    static int func(int r, int c, int prevd){
        if(r<0 || r>=N || c<0 || c>=M) return -INF;
        if(dp[r][c][prevd] != -100000001) return dp[r][c][prevd];
        if(r==N-1 && c==M-1) return map[r][c];

        int ret = -INF;
        if(prevd == 0){
            ret = Math.max(ret, func(r,c+1,0)+map[r][c]);
            ret = Math.max(ret, func(r+1,c,2)+map[r][c]);
        }else if(prevd==1){
            ret = Math.max(ret, func(r,c-1,1)+map[r][c]);
            ret = Math.max(ret, func(r+1,c,2)+map[r][c]);
        }else if(prevd==2){
            ret = Math.max(ret, func(r,c+1,0)+map[r][c]);
            ret = Math.max(ret, func(r, c-1, 1)+map[r][c]);
            ret = Math.max(ret, func(r+1,c,2)+map[r][c]);
        }
        dp[r][c][prevd]=ret;
        return dp[r][c][prevd];
    }
}
