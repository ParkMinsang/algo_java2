package boj;

import java.io.*;
import java.util.Arrays;

public class boj2718 {
    static int n;
    static int[][][][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            dp = new int[n][2][2][2][2];
            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    for(int w=0; w<2; w++){
                        for(int x=0; x<2; x++){
                            Arrays.fill(dp[i][j][w][x], -1);
                        }
                    }
                }
            }

            System.out.println(func(0,0,0,0,0));
        }
    }
    static int func(int idx, int b1, int b2, int b3, int b4){
        if(idx>n) return 0;
        if(idx==n){
            if(b1==0 && b2==0 && b3==0 && b4==0) return 1;
            else return 0;
        }
        if(dp[idx][b1][b2][b3][b4] != -1) return dp[idx][b1][b2][b3][b4];

        int ret=0;
        if(b1==0 && b2==0 && b3==0 && b4==0){
            ret += func(idx+2, 0,0,0,0);
            ret += func(idx+1, 0,0,0,0);
            ret += func(idx+1, 1,1,0,0);
            ret += func(idx+1, 1,0,0,1);
            ret += func(idx+1, 0,0,1,1);
        }else if(b1==1 && b2==1 && b3==0 && b4==0){
            ret += func(idx+1, 0,0,0,0);
            ret += func(idx+1, 0,0,1,1);
        }else if(b1==1 && b2==0 && b3==0 && b4==1){
            ret += func(idx+1, 0,0,0,0);
            ret += func(idx+1, 0,1,1,0);
        }else if(b1==0 && b2==0 && b3==1 && b4==1){
            ret += func(idx+1, 0,0,0,0);
            ret += func(idx+1, 1,1,0,0);
        }else if(b1==0 && b2==1 && b3==1 && b4==0){
            ret += func(idx+1, 1,0,0,1);
        }
        dp[idx][b1][b2][b3][b4] = ret;
        return dp[idx][b1][b2][b3][b4];
    }
}
