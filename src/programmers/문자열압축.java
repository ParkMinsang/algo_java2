package programmers;

import java.util.*;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "abcabcdede";
        int ans=s.length();
        int sl = s.length();

        for(int k=1; k<s.length()/2+1; k++){
            ans=Math.min(ans, func(s, k));
        }
        System.out.println(ans);
    }

    static int func(String s, int k){
        StringBuilder sb = new StringBuilder();
        int leng = s.length()/k;
        int[] cnt = new int[leng];
        Arrays.fill(cnt, 1);

        for(int i=leng-1; i>0; i--){
            if(isSame(s, k, (i-1)*k, i*k)){
                cnt[i-1]+=cnt[i];
            }
        }

        int idx=0;
        int ret=s.length();
        while(idx<leng){
            if(cnt[idx]>1){
                sb.append(cnt[idx]);
                ret -= (cnt[idx]-1)*k;
            }
            idx+=cnt[idx];
        }
        return ret+sb.length();
    }

    static boolean isSame(String s, int k, int idx1, int idx2){
        for(int i=0; i<k; i++){
            if(s.charAt(idx1+i) != s.charAt(idx2+i)) return false;
        }
        return true;
    }
}
