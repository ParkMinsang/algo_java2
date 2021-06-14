package boj;

import java.io.*;
import java.util.*;

public class boj17070 {
    static int n;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(func(0,1,0));
    }
    static int func(int r, int c, int d){
        if(r==n-1 && c==n-1) return 1;
        if(dp[r][c][d] != -1) return dp[r][c][d];

        int ret=0;
        if(d==0){
            if(c+1<n && map[r][c+1]!=1) ret += func(r,c+1, 0);
            if(r+1<n && c+1<n && map[r][c+1]!=1 && map[r+1][c+1]!=1 && map[r+1][c]!=1)
                ret += func(r+1, c+1, 2);
        }else if(d==1){
            if(r+1<n && map[r+1][c] != 1) ret += func(r+1, c, 1);
            if(r+1<n && c+1<n && map[r+1][c] != 1 && map[r+1][c+1] !=1 && map[r][c+1]!=1)
                ret += func(r+1,c+1,2);
        }else{
            if(c+1<n && map[r][c+1] != 1) ret+=func(r,c+1,0);
            if(r+1<n && map[r+1][c] != 1) ret+=func(r+1,c,1);
            if(r+1<n && c+1<n && map[r+1][c]!=1 && map[r][c+1]!=1 && map[r+1][c+1] != 1)
                ret+=func(r+1,c+1,2);
        }
        dp[r][c][d] = ret;
        return dp[r][c][d];
    }
}
