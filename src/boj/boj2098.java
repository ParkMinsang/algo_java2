package boj;

import java.io.*;
import java.util.*;

public class boj2098 {
    static final int INF = 99999999;
    static int n;
    static int[][] cost;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int kind = (int)Math.pow(2, n)-1;
        dp = new int[n+1][kind][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<kind; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(func(1,1,0));
    }
    static int func(int idx, int path, int prev){
        if(idx==n){
            if(cost[prev][0]==0) return INF;
            else return cost[prev][0];
        }
        if(dp[idx][path][prev]!=-1) return dp[idx][path][prev];

        int ret=INF;
        for(int i=0; i<n; i++){
            if((path & (1<<i)) != 0 || cost[prev][i]==0) continue;
            ret = Math.min(ret, cost[prev][i]+func(idx+1, path | (1<<i), i));
        }
        dp[idx][path][prev]=ret;
        return dp[idx][path][prev];
    }
}
