package boj;

import java.io.*;
import java.util.*;

public class boj9251 {
    static String s1,s2;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        dp = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0,0));
    }
    public static int func(int idx1, int idx2){
        if(idx1>=s1.length() || idx2>=s2.length()) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int ans=0;
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            ans = Math.max(ans, func(idx1+1, idx2+1)+1);
        }else{
            ans = Math.max(ans, func(idx1+1, idx2));
            ans = Math.max(ans, func(idx1, idx2+1));
        }
        dp[idx1][idx2] = ans;
        return dp[idx1][idx2];
    }

}
