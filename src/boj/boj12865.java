package boj;

import java.io.*;
import java.util.*;

public class boj12865 {
    static int n,k;
    static int[][] objects;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        objects = new int[n][2];
        dp = new int[n][k+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            objects[i][0]=w;
            objects[i][1]=v;

            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0,0));
    }
    static int func(int idx, int w){
        if(idx==n) return 0;
        if(dp[idx][w] !=-1) return dp[idx][w];

        int ret=0;
        if(w+objects[idx][0] <= k){
            ret = Math.max(func(idx+1, w+objects[idx][0])+objects[idx][1], func(idx+1, w));
        }else{
            ret = func(idx+1, w);
        }
        dp[idx][w]=ret;
        return dp[idx][w];
    }
}
