package boj;

import java.io.*;
import java.util.*;

public class boj1311 {
    static final int INF = 99999999;
    static int n;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1<<n];

        System.out.println(func(0,0));
    }
    static int func(int idx, int done){
        if(idx==n) return 0;
        if(dp[idx][done] != 0) return dp[idx][done];

        int ret= INF;
        for(int i=0; i<n; i++){
            if((done & (1<<i)) != 0) continue;
            ret = Math.min(ret, cost[idx][i]+func(idx+1, done | (1<<i)));
        }
        dp[idx][done] = ret;
        return dp[idx][done];
    }
}
