package boj;

import java.io.*;
import java.util.*;

public class boj1176 {
    static int n,k,kind;
    static int[] height;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        height = new int[n+1];
        for(int i=0; i<n; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        height[n] = 9999999;

        kind = 1<<n;
        dp = new long[kind][n+1];
        for(int i=0; i<kind; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0, n));
    }
    static long func(int students, int beforeStudent){
        if(dp[students][beforeStudent] != -1) return dp[students][beforeStudent];
        if(students == kind-1) return 1;

        long ret=0;
        for(int i=0; i<n; i++){
            if(((students & (1<<i))!=0) || (Math.abs(height[beforeStudent]-height[i]) <= k)) continue;

            ret += func(students | (1<<i), i);
        }
        dp[students][beforeStudent] = ret;
        return dp[students][beforeStudent];
    }
}
