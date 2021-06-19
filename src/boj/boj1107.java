package boj;

import java.io.*;
import java.util.*;

public class boj1107 {
    static int n;
    static int[] dp;
    static boolean[] isBroken;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        isBroken = new boolean[10];

        if(m>0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<m; i++){
                int brokenbtn = Integer.parseInt(st.nextToken());
                isBroken[brokenbtn]=true;
            }
        }

        dp = new int[500001];
        Arrays.fill(dp, -1);

        int ans = Math.abs(n-100);
        for(int i=0; i<10; i++){
            if(isBroken[i]) continue;
            ans = Math.min(ans, 1+func(i));
        }
        System.out.println(ans);
    }
    static int func(int channel){
        if(channel>500000) return Math.abs(channel-n);
        if(dp[channel] != -1) return dp[channel];

        int ret = Math.abs(channel-n);
        for(int i=0; i<10; i++){
            if(isBroken[i] || (channel==0 && i==0)) continue;

            ret = Math.min(ret, 1+func(channel*10+i));
        }
        dp[channel]=ret;
        return dp[channel];
    }
}
