package boj;

import java.io.*;
import java.util.*;

public class boj2133 {
    static int n;
    static int[][][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2][2][2];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        System.out.println(func(0,0,0, 0));
    }
    static int func(int idx, int left, int mid, int right){
        if(idx>n) {
            return 0;
        }
        if(idx==n){
            if(left == 0 && mid == 0 && right == 0) return 1;
            return 0;
        }
        if(dp[idx][left][mid][right] != -1) return dp[idx][left][mid][right];

        int ret=0;
        if(left==0 && mid==0 && right==0){
            ret += func(idx+1, 1,0,0);
            ret += func(idx+1, 0,0,1);
            ret += func(idx+2, 0,0,0);
        }else if(left==1 && mid==0 && right==0){
            ret += func(idx+1, 0,0,0);
            ret += func(idx+1, 0,1,1);
        }else if(left==0 && mid==0 && right==1){
            ret += func(idx+1, 0,0,0);
            ret += func(idx+1, 1,1,0);
        }else if(left==1 && mid==1 && right==0){
            ret += func(idx+1, 0,0,1);
        }else if(left==0 && mid==1 && right==1){
            ret += func(idx+1, 1,0,0);
        }

        dp[idx][left][mid][right] = ret;
        return dp[idx][left][mid][right];
    }

}
