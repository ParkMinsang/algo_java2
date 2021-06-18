package boj;

import java.io.*;
import java.util.*;

public class boj1695 {
    static final int INF = 9999999;
    static int n;
    static int[][] dp;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        System.out.println(func(0, n-1));
    }
    static int func(int s, int e){
        if(s>=e) return 0;
        if(dp[s][e] != -1) return dp[s][e];

        int ret = INF;
        if(nums[s]==nums[e]){
            ret = Math.min(ret, func(s+1, e-1));
        }else{
            ret = Math.min(ret, 1+func(s+1, e));
            ret = Math.min(ret, 1+func(s, e-1));
        }
        dp[s][e] = ret;
        return dp[s][e];
    }
}
