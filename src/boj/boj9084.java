package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9084 {
    static int n,m;
    static int[] coins;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            coins = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                coins[j] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());

            dp = new int[n][m];
            for(int p=0; p<n; p++) Arrays.fill(dp[p], -1);

            sb.append(func(0, 0)).append('\n');
        }
        System.out.println(sb);
    }

    static int func(int idx, int prev){
        if(prev == m) return 1;
        if(idx==n) return 0;
        if(dp[idx][prev]!=-1) return dp[idx][prev];

        int ret=0, tmp=prev;
        while(tmp<=m){
            ret += func(idx+1, tmp);
            tmp += coins[idx];
        }
        dp[idx][prev]=ret;
        return dp[idx][prev];
    }
}
