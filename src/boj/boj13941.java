package boj;

import java.io.*;
import java.util.*;

public class boj13941 {
    static final int INF = 99999999;
    static int n, k;
    static int[][] cost;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1<<n];
        Arrays.fill(dp, -1);

        System.out.println(func(0,0));
    }
    static int func(int glasses, int cnt){
        if(n-cnt == k) return 0;
        if(dp[glasses] != -1) return dp[glasses];

        int ret = INF;
        for(int i=0; i<n; i++){
            if((glasses & (1<<i)) != 0) continue;
            for(int j=0; j<n; j++){
                if(i==j || (glasses & (1<<j)) != 0) continue;
                ret = Math.min(ret, cost[i][j]+func(glasses | (1<<i), cnt+1));
            }
        }

        dp[glasses]=ret;
        return dp[glasses];
    }
}
