package boj;

import java.io.*;
import java.util.*;

public class boj16195 {
    static final int MOD = 1000000009;
    static int n,m;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        dp = new int[1001][1001];
        for(int i=0; i<1001; i++) Arrays.fill(dp[i], -1);

        for(int tc=0; tc<t; tc++){
            st = new StringTokenizer(br.readLine()," ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(func(n, m)).append('\n');
        }
        System.out.println(sb);
    }

    static int func(int num, int cnt){
        if(cnt<0 || num<0) return 0;
        if(num==0) return 1;
        if(dp[num][cnt] != -1) return dp[num][cnt];

        int ret=0;
        for(int i=1; i<4; i++){
            ret = (ret+func(num-i, cnt-1))%MOD;
        }

        dp[num][cnt]=ret;
        return dp[num][cnt];
    }
}
