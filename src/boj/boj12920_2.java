package boj;

import java.io.*;
import java.util.*;

public class boj12920_2 {
    static final int INF = 99999999;
    static int n,m,leng;
    static Obj[] objs;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        leng=0;
        objs = new Obj[10001];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int j=1; k>0; j<<=1){
                int tmp = Math.min(j, k);
                objs[leng]=new Obj(value*tmp, weight*tmp);
                leng++;
                k-=tmp;
            }
        }
//        System.out.println("value");
//        for(int value=0; value<leng; value++){
//            System.out.print(val[value]+" ");
//        }
//        System.out.println();
//        System.out.println("weight");
//        for(int value=0; value<leng; value++){
//            System.out.print(w[value]+" ");
//        }

        dp = new int[leng][m+1];
        for(int i=0; i<leng; i++) Arrays.fill(dp[i], -1);

        System.out.println(func(0, 0));
    }
    static int func(int idx, int k){
        if(k>m) return -INF;
        if(idx==leng || k==m) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];

        int ret=0;
        ret = Math.max(ret, objs[idx].val+func(idx+1, k+objs[idx].w));
        ret = Math.max(ret, func(idx+1, k));

        dp[idx][k]=ret;
        return dp[idx][k];
    }

    static class Obj{
        int val,w;
        Obj(int val, int w){
            super();
            this.val = val;
            this.w=w;
        }
    }
}
