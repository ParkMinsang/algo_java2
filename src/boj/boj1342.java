package boj;

import java.io.*;
import java.util.*;

public class boj1342 {
    static Set<String> stringset;
    static String S;
    static boolean[] isSelected;
    static int ans;
    static int[] perm;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        isSelected = new boolean[S.length()];
        perm = new int[S.length()];

        ans=0;
        stringset = new HashSet<>();
        permutation(0);
        System.out.println(ans);
    }
    static void permutation(int idx){
        if(idx==S.length()){
            if(isLuckyString()){
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<S.length(); i++){
                    sb.append(S.charAt(perm[i]));
                }
                String luckyString = sb.toString();
                if(!stringset.contains(luckyString)){
                    stringset.add(luckyString);
                    ans++;
                }
            }
            return;
        }

        for(int i=0; i<S.length(); i++){
            if(!isSelected[i]){
                isSelected[i]=true;
                perm[idx]=i;
                permutation(idx+1);
                isSelected[i]=false;
            }
        }
    }

    static boolean isLuckyString(){
        char prev='N';
        for(int i=0; i<S.length(); i++){
            if(S.charAt(perm[i])==prev) return false;
            prev = S.charAt(perm[i]);
        }
        return true;
    }

}
