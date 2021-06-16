package boj;

import java.io.*;
import java.util.*;

public class boj11722 {
    static int n;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n][1002];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        System.out.println(func(0,1001));
    }
    static int func(int idx, int prev){
        if(idx==n) return 0;
        if(dp[idx][prev] != 0) return dp[idx][prev];

        int ret=0;
        if(nums[idx]<prev)
            ret = Math.max(ret, 1+func(idx+1, nums[idx]));
        ret = Math.max(ret, func(idx+1, prev));
        dp[idx][prev] = ret;
        return dp[idx][prev];
    }
}
