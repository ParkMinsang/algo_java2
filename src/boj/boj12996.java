package boj;

import java.io.*;
import java.util.*;

public class boj12996 {
    static final int MOD = 1000000007;
    static int s,D,K,H;
    static int[][][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        s = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dp = new int[s][D+1][K+1][H+1];
        for(int i=0; i<s; i++){
            for(int j=0; j<D+1; j++){
                for(int m=0; m<K+1; m++){
                    Arrays.fill(dp[i][j][m], -1);
                }
            }
        }
        System.out.println(func(0,D,K,H));
    }
    static int func(int idx, int d, int k, int h){
        if(d<0 || k<0 || h<0) return 0;
        if(idx==s){
            if(d>0 || k>0 || h>0) return 0;
            return 1;
        }
        if(dp[idx][d][k][h] != -1) return dp[idx][d][k][h];

        int ret=0;
        //1 man
        ret = (ret+func(idx+1, d-1, k, h))%MOD;
        ret = (ret+func(idx+1, d, k-1, h))%MOD;
        ret = (ret+func(idx+1, d, k, h-1))%MOD;
        //2 man
        ret = (ret+func(idx+1, d-1, k-1, h))%MOD;
        ret = (ret+func(idx+1, d-1, k, h-1))%MOD;
        ret = (ret+func(idx+1, d, k-1, h-1))%MOD;
        //3man
        ret = (ret+func(idx+1, d-1, k-1, h-1))%MOD;

        dp[idx][d][k][h] = ret;
        return dp[idx][d][k][h];
    }
}
