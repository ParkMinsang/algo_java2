package boj;

import java.io.*;
import java.util.*;

public class boj9184 {
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[21][21][21];
        for(int i=0; i<21; i++){
            for(int j=0; j<21; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int a=0, b=0, c=0;
        while(true){
            st = new StringTokenizer(br.readLine()," ");

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            sb.append(func(a,b,c)).append('\n');
        }
        System.out.println(sb);
    }

    static int func(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return func(20,20,20);
        if(dp[a][b][c]!=-1) return dp[a][b][c];

        int ret=0;
        if(a<b && b<c) ret = func(a,b,c-1)+func(a,b-1,c-1)-func(a,b-1,c);
        else ret = func(a-1,b,c)+func(a-1,b-1,c)+func(a-1,b,c-1)-func(a-1,b-1,c-1);
        dp[a][b][c]=ret;
        return dp[a][b][c];
    }
}
