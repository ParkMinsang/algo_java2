package boj;

import java.io.*;
import java.util.*;

public class boj15990 {
    static final int MOD = 1000000009;
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        dp = new int[100001][4];
        for(int i=0; i<100001; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            sb.append(func(n,0)).append("\n");
        }
        System.out.println(sb);
    }
    static int func(int num, int prev){
        if(num<0) return 0;
        if(num==0) return 1;
        if(dp[num][prev] != -1) return dp[num][prev];

        int ret=0;
        for(int i=1; i<4; i++){
            if(prev==i) continue;
            ret = (ret+func(num-i, i))%MOD;
        }
        dp[num][prev] = ret;
        return dp[num][prev];
    }
}
