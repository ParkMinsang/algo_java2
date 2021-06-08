package boj;

import java.io.*;
import java.util.*;

public class boj1029 {
    static int n;
    static int[][] cost;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        String costinput = null;
        for(int i=0; i<n; i++){
            costinput = br.readLine();
            for(int j=0; j<n; j++){
                cost[i][j] = (int)(costinput.charAt(j)-'0');
            }
        }
        int kind = (int)Math.pow(2,n);
        dp = new int[kind][n][10];
        for(int i=0; i<kind; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(func(1,0,0)+1);
    }
    static int func(int owner, int prevowner, int prevcost){
        if(dp[owner][prevowner][prevcost] != -1) return dp[owner][prevowner][prevcost];

        int ret=0;
        for(int i=0; i<n; i++){
            if((owner & (1<<i))!=0 || cost[prevowner][i] < prevcost) continue;
            ret = Math.max(ret, 1+func(owner | (1<<i), i, cost[prevowner][i]));
        }
        dp[owner][prevowner][prevcost] = ret;
        return dp[owner][prevowner][prevcost];
    }
}
