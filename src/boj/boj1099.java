package boj;

import java.io.*;
import java.util.*;

public class boj1099 {
    static final int INF=99999999;
    static String comment;
    static String[] words;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comment = br.readLine();
        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        for(int i=0; i<n; i++) words[i] = br.readLine();
        dp = new int[comment.length()+1];
        Arrays.fill(dp,-1);

        int ans=func(0);
        System.out.println(ans==INF?-1:ans);
    }
    static int func(int idx){
        if(idx==comment.length()){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int ret = INF;
        for(String word:words){
            if(idx+word.length()>comment.length()) continue;
            if(isPos(idx, word)){
                ret = Math.min(ret, diffVal(idx, word)+func(idx+word.length()));
            }
        }
        dp[idx]=ret;
        return dp[idx];
    }
    static boolean isPos(int idx, String word){
        int[] alpha=new int[26];
        for(int i=0; i<word.length(); i++){
            alpha[comment.charAt(idx+i)-'a']++;
            alpha[word.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(alpha[i] != 0) return false;
        }
        return true;
    }
    static int diffVal(int idx, String word){
        int res=0;
        for(int i=0; i<word.length(); i++){
            if(comment.charAt(idx+i) != word.charAt(i)){
                res++;
            }
        }
        return res;
    }
}
