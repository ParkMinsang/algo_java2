package boj;

import java.io.*;
import java.util.Arrays;

public class boj14852 {
    static final int MOD = 1000000007;
    static int n;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][2][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(func(0,0,0));
    }
    static int func(int idx, int left, int right){
        if(idx==n && left==0 && right==0) return 1;
        if(idx>=n) return 0;
        if(dp[idx][left][right] != -1) return dp[idx][left][right];

        int ret=0;
        if(left==0 && right==0){
            ret = (ret+func(idx+2, 0,0))%MOD;
            ret = (ret+func(idx+1, 1, 0))%MOD;
            ret = (ret+func(idx+1, 0,1))%MOD;
            ret = (ret+func(idx+1, 0,0))%MOD;
            ret = (ret+func(idx+1, 0,0))%MOD;
        }else if(left==1 && right==0){
            ret = (ret+func(idx+1, 0,0))%MOD;
            ret = (ret+func(idx+1, 0,1))%MOD;
        }else if(left==0 && right==1){
            ret = (ret+func(idx+1, 0,0))%MOD;
            ret = (ret+func(idx+1, 1,0))%MOD;
        }
        dp[idx][left][right] = ret;
        return dp[idx][left][right];
    }
}
