package algospot;

import java.io.*;
import java.util.*;

public class jumpgame {
    static int n;
    static boolean isFind;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dp = new int[n][n];
            isFind = false;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine()," ");

                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = -1;
                }
            }

            System.out.println(func(0,0)>0?"YES":"NO");
        }
    }

    static int func(int r, int c){
        if(isFind) return 0;
        if(r<0 || r>=n || c<0 || c>=n) return 0;
        if(dp[r][c] != -1) return dp[r][c];
        if(r==n-1 && c==n-1){
            isFind=true;
            return 1;
        }

        int ret=0;
        ret += func(r+map[r][c], c);
        ret += func(r, c+map[r][c]);

        dp[r][c]=ret;
        return dp[r][c];
    }
}
