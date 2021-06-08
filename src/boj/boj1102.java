package boj;

import java.io.*;
import java.util.*;

public class boj1102 {
    static final int INF = 99999999;
    static int n, p;
    static int[][] cost, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String state = br.readLine();
        int currstate = 0;
        int currcnt=0;
        for(int i=0; i<state.length(); i++){
            if(state.charAt(i)=='Y'){
                currstate |= (1<<i);
                currcnt++;
            }
        }
        p = Integer.parseInt(br.readLine());
        int kind = (int)(Math.pow(2,n))-1;
        dp = new int[n+1][kind];

        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = func(currcnt, currstate);
        System.out.println(ans>=INF?-1:ans);
    }
    static int func(int cnt, int state){
        if(cnt>=p) return 0;
        if(dp[cnt][state] != -1) return dp[cnt][state];

        int ret = INF;
        for(int i=0; i<n; i++){
            if((state & (1<<i)) != 0){
                for(int j=0; j<n; j++){
                    if((state & (1<<j)) != 0) continue;
                    ret = Math.min(ret, cost[i][j]+func(cnt+1, state | (1<<j)));
                }
            }
        }
        dp[cnt][state] = ret;
        return dp[cnt][state];
    }
}
