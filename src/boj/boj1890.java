package boj;

import java.io.*;
import java.util.*;

public class boj1890 {
    static int n;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new long[n][n];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }

        System.out.println(func(0,0));

    }
    static long func(int r, int c){
        if(r<0 || r>=n || c<0 || c>=n) return 0;
        if(r==n-1 && c==n-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        if(map[r][c]==0) return 0;

        long ret=0;
        ret += func(r+map[r][c], c);
        ret += func(r, c+map[r][c]);

        dp[r][c]=ret;
        return dp[r][c];
    }
}
