package boj;

import java.io.*;
import java.util.*;

public class boj1562 {
    static final int MOD = 1000000000;
    static int n;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n][1<<10][10];
        for(int i=0; i<n; i++){
            for(int j=0; j<(1<<10); j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans=0;
        for(int i=1; i<10; i++){
            ans = (ans+func(1,1<<i,i))%MOD;
        }
        System.out.println(ans);
    }
    static int func(int idx, int use, int prev){
        if(idx==n){
            if(use==(1<<10)-1) return 1;
            return 0;
        }
        if(dp[idx][use][prev] != -1) return dp[idx][use][prev];

        int ret=0;
        if(prev-1>=0){
            ret = (ret + func(idx+1, use|(1<<(prev-1)), prev-1))%MOD;
        }
        if(prev+1<=9){
            ret = (ret + func(idx+1, use|(1<<(prev+1)), prev+1))%MOD;
        }
        dp[idx][use][prev] = ret;
        return dp[idx][use][prev];
    }


}
