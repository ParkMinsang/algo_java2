package boj;

import java.io.*;
import java.util.*;

public class boj2342 {
    static final int INF=999999999;
    static int n;
    static int[] pad = new int[100000];
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n=0;
        int idx=0;
        while(true){
            idx = Integer.parseInt(st.nextToken());
            if(idx==0) break;
            pad[n++]=idx;
        }
        dp = new int[n+1][5][5];

        System.out.println(func(0,0,0));
    }
    static int func(int idx, int left, int right){
        if(idx==n) return 0;
        if(dp[idx][left][right]!=0) return dp[idx][left][right];

        int ret = INF;
        if(left==0){
            ret = Math.min(ret, func(idx+1, pad[idx], right)+2);
        }else if(left == pad[idx]){
            ret = Math.min(ret, func(idx+1, pad[idx], right)+1);
        }else if(Math.abs(left-pad[idx])==2){
            ret = Math.min(ret, func(idx+1, pad[idx], right)+4);
        }else{
            ret = Math.min(ret, func(idx+1, pad[idx], right)+3);
        }
        if(right==0){
            ret = Math.min(ret, func(idx+1, left, pad[idx])+2);
        }else if(right==pad[idx]){
            ret = Math.min(ret, func(idx+1, left, pad[idx])+1);
        }else if(Math.abs(right-pad[idx])==2){
            ret = Math.min(ret, func(idx+1, left, pad[idx])+4);
        }else{
            ret = Math.min(ret, func(idx+1, left, pad[idx])+3);
        }
        dp[idx][left][right] = ret;
        return dp[idx][left][right];
    }
}
