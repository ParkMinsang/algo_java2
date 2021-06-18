package boj;

import java.io.*;
import java.util.*;

public class boj16637 {
    static int n, ans;
    static char[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        ans=0;
        dfs(0,0);
        System.out.println(ans);
    }
    static void dfs(int idx, int path){
        if(idx>=n/2){
            System.out.println(Integer.toBinaryString(path));
            return;
        }

        dfs(idx+2, path|(1<<idx));
        dfs(idx+1, path);
    }
}
