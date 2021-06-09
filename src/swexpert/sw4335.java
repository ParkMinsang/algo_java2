package swexpert;

import java.util.Scanner;
/*
Fail Code
* */
public class sw4335 {
    static int ans, n;
    static int[][][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            n = sc.nextInt();
            int[][] squares = new int[n+1][3];
            for(int i=0; i<n; i++){
                for(int j=0; j<3; j++){
                    squares[i][j] = sc.nextInt();
                }
            }
            dp = new int[1<<n][n+1][3];
            for(int i=0; i<(1<<n); i++){
                for(int j=0; j<n+1; j++){
                    for(int l=0; l<3; l++){
                        dp[i][j][l]=-1;
                    }
                }
            }
            squares[n][0]=10001; squares[n][1]=10001; squares[n][2]=10001;
            System.out.println("#"+tc+" "+heighest(0,n,0, squares));
        }
    }
    static int heighest(int used, int prev, int prevd, int[][] squares){
        if(used==(1<<n)-1) return 0;
        if(dp[used][prev][prevd] != -1) return dp[used][prev][prevd];

        int ret=0, res=0;
        for(int i=0; i<n; i++){
            if((used & (1<<i)) != 0) continue;

            if(prevd==0){
                if(isPos(squares[prev][0], squares[prev][1], squares[i][0], squares[i][1])){
                    res = squares[i][2]+heighest(used | (1<<i), i, 0, squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][0], squares[prev][1], squares[i][0], squares[i][2])){
                    res = squares[i][1]+heighest(used | (1<<i), i, 1,squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][0], squares[prev][1], squares[i][1], squares[i][2])){
                    res = squares[i][0]+heighest(used | (1<<i), i, 2,squares);
                    ret = res>ret?res:ret;
                }
            }else if(prevd==1){
                if(isPos(squares[prev][0], squares[prev][2], squares[i][0], squares[i][1])){
                    res = squares[i][2]+heighest(used | (1<<i), i, 0,squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][0], squares[prev][2], squares[i][0], squares[i][2])){
                    res = squares[i][1]+heighest(used | (1<<i), i, 1,squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][0], squares[prev][2], squares[i][1], squares[i][2])){
                    res = squares[i][0]+heighest(used | (1<<i), i, 2,squares);
                    ret = res>ret?res:ret;
                }
            }else if(prevd==2){
                if(isPos(squares[prev][1], squares[prev][2], squares[i][0], squares[i][1])){
                    res = squares[i][2]+heighest(used | (1<<i), i, 0,squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][1], squares[prev][2], squares[i][0], squares[i][2])){
                    res = squares[i][1]+heighest(used | (1<<i), i, 1,squares);
                    ret = res>ret?res:ret;
                }
                if(isPos(squares[prev][1], squares[prev][2], squares[i][1], squares[i][2])){
                    res = squares[i][0]+heighest(used | (1<<i), i, 2,squares);
                    ret = res>ret?res:ret;
                }
            }
        }
        dp[used][prev][prevd] = ret;
        return dp[used][prev][prevd];
    }
    static boolean isPos(int prevw, int prevh, int currw, int currh){
        if(prevw >= currw && prevh >= currh) return true;
        else if(prevw >= currh && prevh >= currw) return true;
        return false;
    }
}
