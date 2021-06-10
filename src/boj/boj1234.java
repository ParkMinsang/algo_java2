package boj;

import java.io.*;
import java.util.*;

public class boj1234 {
    static int[] fact;
    static int n,R,G,B;
    static long dp[][][][];
    public static void main(String[] args) throws IOException{
        fact = new int[11];
        fact[1] = 1;
        for(int i=2; i<11; i++) fact[i]=fact[i-1]*i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dp = new long[n+1][R+1][G+1][B+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<R+1; j++){
                for(int m=0; m<G+1; m++){
                    Arrays.fill(dp[i][j][m],-1);
                }
            }
        }

        System.out.println(func(1,R,G,B));
    }
    static long func(int idx, int r, int g, int b){
        if(r<0 || g<0 || b<0) return 0;
        if(idx==n+1) return 1;
        if(dp[idx][r][g][b] != -1) return dp[idx][r][g][b];

        long ret=0;
        ret += func(idx+1, r-idx, g,b);
        ret += func(idx+1, r, g-idx, b);
        ret += func(idx+1, r,g,b-idx);
        if(idx%2==0){
            ret += func(idx+1, r-idx/2, g-idx/2, b)*fact[idx]/((long) fact[idx / 2] *fact[idx/2]);
            ret += func(idx+1, r-idx/2, g, b-idx/2)*fact[idx]/((long) fact[idx / 2] *fact[idx/2]);
            ret += func(idx+1, r, g-idx/2, b-idx/2)*fact[idx]/((long) fact[idx / 2] *fact[idx/2]);
        }
        if(idx%3==0){
            ret += func(idx+1, r-idx/3, g-idx/3, b-idx/3)*fact[idx]/((long) fact[idx / 3] *fact[idx/3]*fact[idx/3]);
        }
        dp[idx][r][g][b] = ret;
        return dp[idx][r][g][b];
    }
}
