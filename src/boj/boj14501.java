package boj;

import java.io.*;
import java.util.*;

public class boj14501 {
    static int n;
    static int[] time, pay, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n];
        pay = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(func(0));
    }

    static int func(int idx){
        if(idx==n) return 0;
        if(dp[idx] != -1) return dp[idx];

        int ret=0;
        if(idx+time[idx]<=n){
            ret = Math.max(ret, pay[idx]+func(idx+time[idx]));
        }
        ret = Math.max(ret, func(idx+1));
        dp[idx] = ret;
        return dp[idx];
    }
}
