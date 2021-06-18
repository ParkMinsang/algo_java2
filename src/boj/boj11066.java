package boj;

import java.io.*;
import java.util.*;

public class boj11066 {
    static final int INF = 99999999;
    static int k;
    static int[] costs, presum;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            k = Integer.parseInt(br.readLine());
            costs = new int[k];
            presum = new int[k];
            dp = new int[k][k];

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<k; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
                presum[i] += ((i-1)>=0?presum[i-1]:0)+costs[i];
            }

            System.out.println(func(0, k-1));
        }
    }
    static int func(int lt, int rt){
        if(lt==rt) return 0;
        if(dp[lt][rt] != 0) return dp[lt][rt];

        int sum=presum[rt];
        if(lt-1>=0) sum-=presum[lt-1];

        int ret=INF;
        for(int mt = lt; mt<rt; mt++){
            int l = func(lt, mt);
            int r = func(mt+1, rt);
            ret=Math.min(ret, sum+ func(lt, mt)+func(mt+1, rt));
        }
        dp[lt][rt]=ret;
        return dp[lt][rt];
    }
}
