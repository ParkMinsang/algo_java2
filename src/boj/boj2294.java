package boj;

import java.io.*;
import java.util.*;

public class boj2294 {
    static final int INF = 1000001;
    static int n,k;
    static int[] coins, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[100001];
        Arrays.fill(dp,-1);
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(func(0)==INF?-1:func(0));
    }

    static int func(int money){
        if(money>k) return INF;
        if(money==k) return 0;
        if(dp[money] != -1) return dp[money];

        int ret=INF;
        for(int i=0; i<n; i++){
            ret = Math.min(ret, 1+func(money+coins[i]));
        }
        dp[money]=ret;
        return dp[money];
    }
}
