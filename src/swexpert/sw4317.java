package swexpert;

import java.util.Scanner;
/*
Fail Code
* */
public class sw4317 {
    static int h,w;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++){
            h = sc.nextInt();
            w = sc.nextInt();

            board = new int[h][w];
            dp = new int[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    board[i][j] = sc.nextInt();
                    dp[i][j] = -1;
                }
            }

            System.out.println("#"+tc+" "+func(0,0));

        }
    }
    static int func(int r, int c){
        return 0;
    }
}
