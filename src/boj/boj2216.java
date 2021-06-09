package boj;

import java.io.*;
import java.util.*;

public class boj2216 {
    static final int INF = 999999999;
    static int a,b,c;
    static int[][] dp;
    static String s1, s2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s1 = br.readLine();
        s2 = br.readLine();

        dp = new int[s1.length()][s2.length()];
        for(int i=0; i<s1.length(); i++){
            Arrays.fill(dp[i], -INF);
        }

        System.out.println(func(0,0));
    }
    static int func(int idx1, int idx2){
        if(idx1 == s1.length() && idx2 == s2.length()) return 0;
        else if(idx1 == s1.length() && idx2 < s2.length()) return b*(s2.length()-idx2);
        else if(idx2 == s2.length() && idx1 < s1.length()) return b*(s1.length()-idx1);
        if(dp[idx1][idx2] != -INF) return dp[idx1][idx2];

        int ret=-INF;
        ret=Math.max(ret, func(idx1+1, idx2+1) + (s1.charAt(idx1)==s2.charAt(idx2)?a:c));
        ret=Math.max(ret, b+func(idx1+1, idx2));
        ret=Math.max(ret, b+func(idx1, idx2+1));

        dp[idx1][idx2]=ret;
        return dp[idx1][idx2];
    }
}
