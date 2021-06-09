package boj;

import java.io.*;
import java.util.*;

public class boj2306 {
    static String dna;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dna = br.readLine();
        dp = new int[dna.length()][dna.length()];
        for(int i=0; i<dna.length(); i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(func(0,dna.length()-1));
    }
    static int func(int s, int e){
        if(s>=e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];

        int ret=0;
        for(int k=s; k<e; k++){
            ret = Math.max(ret, func(s,k)+func(k+1,e));
        }
        if(dna.charAt(s)=='a' && dna.charAt(e)=='t'){
            ret = Math.max(ret, func(s+1,e-1)+2);
        }
        else if(dna.charAt(s)=='g' && dna.charAt(e)=='c'){
            ret = Math.max(ret, func(s+1, e-1)+2);
        }
        dp[s][e]=ret;
        return dp[s][e];
    }
}
