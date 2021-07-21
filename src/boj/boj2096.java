package boj;

import java.io.*;
import java.util.*;

public class boj2096 {
    static int n;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][3];
        dp = new int[n+1][4];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i],-1);

        StringTokenizer st = null;

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxans = func(0, 3);

        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);
        int minans = func2(0,3);

        System.out.println(maxans+" "+minans);

    }
    static int func(int idx, int curr){
        if(idx==n+1) return 0;
        if(dp[idx][curr]!=-1) return dp[idx][curr];

        int ret=0;
        if(curr!=0) ret=Math.max(ret, (curr==3?0:map[idx][curr])+func(idx+1, 2));
        if(curr!=2) ret=Math.max(ret, (curr==3?0:map[idx][curr])+func(idx+1, 0));
        ret = Math.max(ret, (curr==3?0:map[idx][curr])+func(idx+1, 1));

        dp[idx][curr]=ret;
        return dp[idx][curr];
    }

    static int func2(int idx, int curr){
        if(idx==n+1) return 0;
        if(dp[idx][curr]!=-1) return dp[idx][curr];

        int ret=900001;
        if(curr!=0) ret=Math.min(ret, (curr==3?0:map[idx][curr])+func2(idx+1, 2));
        if(curr!=2) ret=Math.min(ret, (curr==3?0:map[idx][curr])+func2(idx+1, 0));
        ret = Math.min(ret, (curr==3?0:map[idx][curr])+func2(idx+1, 1));

        dp[idx][curr]=ret;
        return dp[idx][curr];
    }

}
