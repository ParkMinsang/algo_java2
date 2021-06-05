package boj;

import java.io.*;
import java.util.*;

public class boj17208 {
    static int n,m,k;
    static int[] x,y;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        x = new int[n]; y = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][m+1][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m+1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(func(0,m,k));

    }
    public static int func(int idx, int b, int p){
        if(idx==n || b<=0 || p<=0) return 0;
        if(dp[idx][b][p] != -1) return dp[idx][b][p];

        int res=0;
        if(b>=x[idx] && p>=y[idx]){
            res = Math.max(res, 1+func(idx+1, b-x[idx], p-y[idx]));
        }
        res = Math.max(res, func(idx+1, b,p));

        dp[idx][b][p] = res;
        return dp[idx][b][p];
    }
}
