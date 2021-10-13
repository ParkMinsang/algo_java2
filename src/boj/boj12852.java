package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj12852 {
    static final int INF = Integer.MAX_VALUE;
    static int[] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        Arrays.fill(dp, INF);
        System.out.println(func(n));
        sb = new StringBuilder();
        output(n);
        System.out.println(sb);
    }
    static int func(int n){

        if(n==1) return 0;
        if(dp[n]!=INF) return dp[n];

        int ret=INF;

        if(n%3==0){
            ret = Math.min(ret, func(n/3)+1);
        }
        if(n%2==0){
            ret = Math.min(ret, func(n/2)+1);
        }
        ret = Math.min(ret, func(n-1)+1);

        dp[n] = ret;
        return dp[n];
    }
    static void output(int n){
        if(n==1){
            sb.append(1);
            return;
        }
        sb.append(n).append(' ');
        int next=0;
        int ret=INF;
        if(n%3==0 && func(n)>func(n/3)){
            ret = Math.min(ret, func(n/3));
            next = n/3;
        }
        if(n%2==0 && func(n)>func(n/2)){
            ret = Math.min(ret, func(n/2));
            next = n/2;
        }
        if(func(n)>func(n-1)){
            ret = Math.min(ret, func(n-1));
            next = n-1;
        }

        output(next);
    }
}
