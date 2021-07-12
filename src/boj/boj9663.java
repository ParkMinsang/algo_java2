package boj;

import java.io.*;
import java.util.*;

public class boj9663 {
    static int n, ans;
    static int[] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        ans=0;
        func(0);
        System.out.println(ans);
    }
    static void func(int idx){
        if(idx==n){
            ans++;
            return;
        }

        for(int i=0; i<n; i++){
            boolean isPos=true;

            for(int j=0; j<idx; j++){
                if(board[j]==i || (idx-j) == Math.abs(board[j]-i)){
                    isPos=false;
                    break;
                }
            }

            if(isPos){
                board[idx]=i;
                func(idx+1);
            }
        }
    }
}
