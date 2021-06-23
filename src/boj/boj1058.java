package boj;

import java.io.*;
import java.util.*;

public class boj1058 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] board = new String[n];

        for(int i=0; i<n; i++){
            board[i] = br.readLine();
        }

        int ans=0;
        for(int i=0; i<n; i++){
            int friends = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(board[i].charAt(j)=='Y') friends++;
                else{
                    for(int k=0; k<n; k++){
                        if(board[i].charAt(k)=='Y' && board[k].charAt(j)=='Y'){
                            friends++;
                            break;
                        }
                    }
                }
            }
            ans = Math.max(ans, friends);
        }
        System.out.println(ans);
    }
}
