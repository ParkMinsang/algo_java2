package boj;

import java.io.*;
import java.util.*;

public class boj2228 {
    static final int INF = -99999999;
    static int n,m;
    static int[] val;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        val = new int[n];
        for(int i=0; i<n; i++) val[i] = Integer.parseInt(br.readLine());

        dp = new int[n][m+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], INF);
        }

        System.out.println(func(0,1));
    }
    static int func(int idx, int curr){
        if(idx>=n){
            if(curr==m+1) return 0;
            return INF;
        }
        if(curr>m) return INF;
        if(dp[idx][curr] != INF) return dp[idx][curr];

        int ret=INF, sum=0;
        for(int i=idx; i<n; i++){
            sum+=val[i];
            ret = Math.max(ret, sum+func(i+2, curr+1));
        }
        ret=Math.max(ret, func(idx+1, curr));

        dp[idx][curr]=ret;
        return dp[idx][curr];
    }
}
