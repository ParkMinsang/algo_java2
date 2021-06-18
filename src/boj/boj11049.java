package boj;

import java.io.*;
import java.util.*;

public class boj11049 {
    static int n;
    static int[][] dp;
    static Mat[] mats;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mats = new Mat[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            mats[i] = new Mat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        System.out.println(func(0, n-1));
    }
    static int func(int idx1, int idx2){
        if(idx1>=n || idx2<0 || idx1==idx2) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int ret = Integer.MAX_VALUE;
        ret = Math.min(ret, mulMat(idx1, idx1+1)+func(idx1+2, idx2));
        ret = Math.min(ret, func(idx1, idx2-2)+mulMat(idx2-1, idx1));

        dp[idx1][idx2] = ret;
        return dp[idx1][idx2];
    }

    static int mulMat(int idx1, int idx2){
        Mat mat1 = mats[idx1];
        Mat mat2 = mats[idx2];
        return mat1.r*mat1.c*mat2.c;
    }

    static class Mat{
        int r,c;
        Mat(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
