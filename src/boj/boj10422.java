package boj;

import java.io.*;
import java.util.*;
/**
 * Fail Code
 * */
public class boj10422 {
    static final int MOD = 1000000007;
    static int n;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        dp = new long[5000][5000];
        for(int i=0; i<5000; i++){
            Arrays.fill(dp[i], -1);
        }
        func(0, 4999);
        System.out.println("끝");
        System.out.println(func(0,3));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            System.out.println(func(0, n-1));
        }
    }
    static long func(int s, int e){
        if(s>=e || (e-s)%2==0) return 0;
        else if(s+1 == e) return 1;
        if(dp[s][e] != -1) return dp[s][e];

        System.out.println(s+" "+e);
        long ret=0;
        for(int k=s+1; k<e-1; k++){
            ret = (ret + (func(s,k)*func(k+1,e))%MOD)%MOD;
        }
        ret = (ret+func(s+1, e-1))%MOD;
        dp[s][e] = ret;
        return dp[s][e];
    }
}
