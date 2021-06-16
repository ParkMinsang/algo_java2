package boj;

import java.io.*;
import java.util.*;

public class boj1010 {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[30][30];
        for(int i=0; i<30; i++){
            Arrays.fill(dp[i], -1);
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(func(n,r));
        }
    }
    static int func(int n, int r){
        if(n==r || r==0) return 1;
        if(dp[n][r]!=-1) return dp[n][r];
        int ret=func(n-1,r-1)+func(n-1,r);
        dp[n][r]=ret;
        return dp[n][r];
    }
}
