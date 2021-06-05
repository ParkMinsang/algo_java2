package boj;

import java.io.*;
import java.util.*;

public class boj17404 {
    static final int INF=99999999;
    static int n, start;
    static int[][][] dp;
    static int[][] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][4][4];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<4; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        cost = new int[n][3];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(func(0,3,3));
    }
    static int func(int idx, int prev, int start){
        if(idx==n) return 0;
        if(dp[idx][prev][start] != -1) return dp[idx][prev][start];

        int ret=INF;
        for(int c=0; c<3; c++){
            if(c==prev) continue;
            if(idx==0){
                ret = Math.min(ret, cost[idx][c]+func(idx+1, c, c));
            }else if(idx==n-1){
                if(c==start){
                    ret = Math.min(ret, INF+func(idx+1, c, start));
                }else{
                    ret = Math.min(ret, cost[idx][c]+func(idx+1, c, start));
                }
            }else{
                ret = Math.min(ret, cost[idx][c]+func(idx+1, c, start));
            }

        }
        dp[idx][prev][start] = ret;
        return dp[idx][prev][start];
    }
}
