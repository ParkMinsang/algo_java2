package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7579 {
    static int INF;
    static int n,m;
    static int[] mem, cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mem = new int[n];
        cost = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) mem[i] = Integer.parseInt(st.nextToken());
        INF = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            INF += cost[i];
        }

        dp = new int[n][INF];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        int ans = INF;
        for(int i=0; i<n; i++){
            for(int j=0; j<INF; j++){
                if(j>=ans) break;
                if(func(i, j)>=m){
                    ans = Math.min(ans, j);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    static int func(int idx, int prevcost){
        if(idx==n) return 0;
        if(dp[idx][prevcost]!=-1) return dp[idx][prevcost];

        int ret = 0;
        ret = Math.max(ret, func(idx+1, prevcost));
        if(prevcost>=cost[idx]){
            ret = Math.max(ret, func(idx+1, prevcost-cost[idx])+mem[idx]);
        }

        dp[idx][prevcost]=ret;
        return dp[idx][prevcost];
    }
}
