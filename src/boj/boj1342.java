package boj;

import java.io.*;
import java.util.*;

public class boj1342 {
    static String S;
    static int ans;
    static int[] alpha;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        alpha = new int[26];
        for(int i=0; i<S.length(); i++){
            alpha[S.charAt(i)-'a']++;
        }

        ans = 0;
        permutation(0, -1);
        System.out.println(ans);
    }

    static void permutation(int idx, int prev){
        if(idx==S.length()){
            ans++;
            return;
        }

        for(int i=0; i<26; i++){
            if(alpha[i]==0 || prev==i) continue;
            alpha[i]--;
            permutation(idx+1, i);
            alpha[i]++;
        }
    }
}
