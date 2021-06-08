package boj;

import java.io.*;
import java.util.*;

public class boj17351 {
    static int n;
    static char[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        dp = new int[n+1][n+1][4];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        String s=null;
        for(int i=0; i<n; i++){
            s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(func(0,0,0));
    }
    static int func(int r, int c, int s){
        if(r>=n || c>=n) return 0;
        if(dp[r][c][s] != -1) return dp[r][c][s];

        int ret=0;

        if(map[r][c]=='M'){
            ret = Math.max(ret, func(r+1, c, 1));
            ret = Math.max(ret, func(r, c+1, 1));
        }else if(map[r][c]=='O' && s==1){
            ret = Math.max(ret, func(r+1, c,2));
            ret = Math.max(ret, func(r,c+1,2));
        }else if(map[r][c]=='L' && s==2){
            ret = Math.max(ret, func(r+1, c, 3));
            ret = Math.max(ret, func(r,c+1,3));
        }else if(map[r][c]=='A' && s==3){
            ret = Math.max(ret, 1+func(r+1,c,0));
            ret = Math.max(ret, 1+func(r,c+1,0));
        }else{
            ret = Math.max(ret, func(r+1,c,0));
            ret = Math.max(ret, func(r,c+1,0));
        }
        dp[r][c][s]=ret;
        return dp[r][c][s];
    }
}
