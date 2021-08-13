package boj;

import java.io.*;
import java.util.*;

public class boj12865_2 {
    static int n,k;
    static int[] weights, values;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        weights = new int[n];
        values = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(func(0,0));
    }
    static int func(int idx, int w){
        if(idx==n || w==k) return 0;
        if(dp[idx][w] != -1) return dp[idx][w];

        int ret = 0;
        ret = Math.max(ret, func(idx+1, w));
        if(weights[idx]+w<=k){
            ret = Math.max(ret, func(idx+1, w+weights[idx])+values[idx]);
        }

        dp[idx][w]=ret;
        return dp[idx][w];
    }
}
