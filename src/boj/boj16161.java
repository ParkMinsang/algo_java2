package boj;

import java.io.*;
import java.util.*;

public class boj16161 {
    static final int INF = 99999999;
    static int n;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0, n-1));
    }

    static int func(int s, int e){
        if(s>e) return 0;
        if(s==e) return 1;
        if(dp[s][e] != -1) return dp[s][e];

        int ret = -INF;
        if(nums[s] == nums[e]){
            if(s+1==e) ret=Math.max(ret, 2);

        }

        return ret;
    }
}
