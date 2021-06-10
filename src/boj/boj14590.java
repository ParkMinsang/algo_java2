package boj;

import java.io.*;
import java.util.*;

public class boj14590 {
    static int n;
    static int[][] dp;
    static int[][] board;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[1<<n][n];
        for(int i=0; i<(1<<n); i++) Arrays.fill(dp[i], -1);

        sb = new StringBuilder();
        sb.append(1).append(" ");
        System.out.println(1+func(1,0));
        output(1,0);
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    static int func(int player, int prev){
        if(player == (1<<n)-1) return 0;
        if(dp[player][prev] != -1) return dp[player][prev];

        int ret=0;
        for(int i=1; i<n; i++){
            if((player & (1<<i))!=0) continue;
            if(board[prev][i]==1){
                ret = Math.max(ret, 1+func(player | (1<<i), i));
            }
        }
        dp[player][prev]=ret;
        return dp[player][prev];
    }
    static void output(int player, int prev){
        if(player == (1<<n)-1) return;

        int next=0;
        int ret=0;
        for(int i=1; i<n; i++){
            if((player & (1<<i))!=0) continue;
            if(board[prev][i]==1){
                if(ret < 1+func(player | (1<<i), i)){
                    next = i;
                    ret = 1+func(player | (1<<i), i);
                }
            }
        }

        if(next==0) return;
        sb.append(next+1).append(" ");
        output(player | (1<<next), next);
    }
}
