package boj;

import java.io.*;
import java.util.*;

public class boj1106 {
    static final int INF = 100001;
    static int n;
    static int[] cost, customer;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dp = new int[n][c+1];
        cost = new int[n];
        customer = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int answer = func(0, c);
        System.out.println(answer);
    }

    static int func(int idx, int k){
        if(k<=0) return 0;
        if(idx>=n) return INF;
        if(dp[idx][k] != 0) return dp[idx][k];

        int ret = INF;
        int m = k/customer[idx] + (k%customer[idx]==0?0:1);

        for(int i=0; i<=m; i++){
            ret = Math.min(ret, func(idx+1, k-customer[idx]*i) + cost[idx]*i);
        }

        dp[idx][k] = ret;
        return dp[idx][k];
    }
}
