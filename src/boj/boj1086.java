package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1086 {
    static int n, k;
    static long[][] dp;
    static int[][] mem;
    static String[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new String[n];
        for(int i=0; i<n; i++){
            nums[i] = br.readLine();
        }
        k = Integer.parseInt(br.readLine());
        dp = new long[1<<(n+1)][k];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        mem = new int[n][k];
        for(int i=0; i<n; i++) Arrays.fill(mem[i], -1);

        long cnt = func(0,0);
        long denom = getFactorial(n);
        long gcd = getGCD(cnt, denom);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt/gcd).append('/').append(denom/gcd);
        System.out.println(sb);
    }
    static long func(int visit, int rest){
        if(visit == (1<<(n))-1){
            if(rest==0) return 1;
            else return 0;
        }
        if(dp[visit][rest]!=-1) return dp[visit][rest];

        long ret = 0;
        for(int i=0; i<n; i++){
            if((visit & (1<<i)) != 0) continue;

            int nrest = getRest(i, rest);
            ret += func(visit | (1<<i), nrest);
        }

        dp[visit][rest]=ret;
        return dp[visit][rest];
    }

    static int getRest(int idx, int prev){
        if(mem[idx][prev] != -1) return mem[idx][prev];

        int rest=prev;
        for(int i=0; i<nums[idx].length(); i++){
            int curr = nums[idx].charAt(i)-'0';
            curr = rest*10+curr;
            rest = curr%k;
        }
        mem[idx][prev]=rest;
        return mem[idx][prev];
    }

    static long getGCD(long a, long b){
        if(b==0) return a;
        else return getGCD(b, a%b);
    }

    static long getFactorial(int n){
        long ret=1;
        for(int i=2; i<=n; i++){
            ret *= i;
        }
        return ret;
    }
}
