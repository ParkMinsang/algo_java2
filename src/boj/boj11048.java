package boj;

import java.io.*;
import java.util.*;

public class boj11048 {
    static int n,m;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
        System.out.println(func(0,0));
    }
    static int func(int r, int c){
        if(r>=n || c>=m) return 0;
        if(dp[r][c] != -1) return dp[r][c];
        int ret=0;
        ret = Math.max(ret, map[r][c]+func(r+1,c));
        ret = Math.max(ret, map[r][c]+func(r,c+1));
        ret = Math.max(ret, map[r][c]+func(r+1,c+1));
        dp[r][c] = ret;
        return dp[r][c];
    }
}
