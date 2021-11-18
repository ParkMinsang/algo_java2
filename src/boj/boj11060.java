package boj;

import java.io.*;
import java.util.*;

public class boj11060{
    static final int INF = 1001;
    static int n;
    static int[] miro, dp;
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    miro = new int[n];
    dp = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    for(int i=0; i<n; i++) miro[i] = Integer.parseInt(st.nextToken());
    Arrays.fill(dp, -1);

    int ans = func(0);
    System.out.println(ans==INF?-1:ans);
}

    static int func(int idx){
        if(idx==n-1) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int ret = INF;
        for(int i=1; i<=miro[idx]; i++){
            if(idx+i>=n) break;
            ret = Math.min(ret, func(idx+i)+1);
        }
        dp[idx]=ret;
        return dp[idx];
    }
}