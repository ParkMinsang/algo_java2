package boj;

import java.io.*;
import java.util.*;

public class boj1915 {
    static int n,m;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i=0; i<n; i++){
            String l = br.readLine();

            for(int j=0; j<m; j++){
                map[i][j] = l.charAt(j)-'0';
            }
            Arrays.fill(dp[i], -1);
        }

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans, func(i,j)*func(i,j));
            }
        }
        System.out.println(ans);
    }

    static int func(int r, int c){
        if(r<0 || r>=n || c<0 || c>=m) return 0;
        if(dp[r][c]!=-1) return dp[r][c];
        if(map[r][c]==0) return 0;

        int ret=1;
        if(func(r+1, c)>0 && func(r,c+1)>0 && func(r+1, c+1)>0){
            int minl = Math.min(func(r+1,c), func(r,c+1));
            minl = Math.min(minl, func(r+1, c+1));

            ret = minl+1;
        }

        dp[r][c]=ret;
        return dp[r][c];
    }
}
