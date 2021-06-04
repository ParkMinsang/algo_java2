package boj;

import java.io.*;
import java.util.*;

public class boj1958 {
    static String s1,s2,s3;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        s3 = br.readLine();

        dp = new int[s1.length()][s2.length()][s3.length()];
        for(int i=0; i<s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(func(0,0,0));
    }
    public static int func(int idx1, int idx2, int idx3){
        if(idx1 >= s1.length() || idx2 >= s2.length() || idx3>=s3.length()) return 0;
        if(dp[idx1][idx2][idx3] != -1) return dp[idx1][idx2][idx3];

        int res=0;
        if(s1.charAt(idx1) == s2.charAt(idx2) && s2.charAt(idx2) == s3.charAt(idx3)){
            res = Math.max(res, func(idx1+1, idx2+1, idx3+1)+1);
        }else{
            res = Math.max(res, func(idx1+1, idx2, idx3));
            res = Math.max(res, func(idx1, idx2+1, idx3));
            res = Math.max(res, func(idx1, idx2, idx3+1));
        }
        dp[idx1][idx2][idx3] = res;
        return dp[idx1][idx2][idx3];
    }
}
