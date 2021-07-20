package boj;

import java.io.*;
import java.util.*;

public class boj10942 {
    static int n;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(func(s-1, e-1)).append('\n');
        }
        System.out.println(sb);
    }
    static int func(int s, int e){
        if(s==e || s>e) return 1;
        if(dp[s][e] != -1) return dp[s][e];

        int ret=0;
        if(arr[s]==arr[e]) ret = func(s+1, e-1);

        dp[s][e]=ret;
        return dp[s][e];
    }
}
