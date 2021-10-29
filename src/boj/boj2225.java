package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2225 {
    static final int MOD = 1000000000;
    static int n,k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];

        System.out.println(func(0, 0));
    }
    static int func(int num, int cnt){
        if(num>n || cnt>k) return 0;
        if(num==n && cnt==k) return 1;
        if(dp[num][cnt]!=0) return dp[num][cnt];

        int ret=0;
        for(int i=0; i<=n; i++){
            ret = (ret + func(num+i, cnt+1))%MOD;
        }
        dp[num][cnt]=ret;
        return dp[num][cnt];
    }


}
