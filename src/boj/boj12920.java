package boj;

import java.io.*;
import java.util.*;

public class boj12920 {
    static final int INF = 99999999;
    static int n,m;
    static ArrayList<Integer> val,w;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        w = new ArrayList<>();
        val = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int j=1; k>0; j<<=1){
                int tmp = Math.min(j, k);
                w.add(weight * tmp);
                val.add(value * tmp);
                k-=tmp;
            }
        }
//        System.out.println("value");
//        for(int value : val){
//            System.out.print(value+ " ");
//        }
//        System.out.println();
//        System.out.println("weight");
//        for(int weight : w){
//            System.out.print(weight+ " ");
//        }

        n = val.size();
        dp = new int[n][m+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        System.out.println(func(0, 0));
    }
    static int func(int idx, int k){
        if(k>m) return -INF;
        if(idx==n || k==m) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];

        int ret=0;
        ret = Math.max(ret, val.get(idx)+func(idx+1, k+w.get(idx)));
        ret = Math.max(ret, func(idx+1, k));

        dp[idx][k]=ret;
        return dp[idx][k];
    }
}
