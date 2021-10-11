package boj;

import java.io.*;
import java.util.*;

public class boj1039 {
    static int ans, k;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isVisited = new boolean[k+1][1000001];

        ans=-1;
        func(0, n);
        System.out.println(ans);
    }
    static void func(int cnt, int val){
        if(isVisited[cnt][val]) return;
        isVisited[cnt][val]=true;
        if(cnt==k){
            ans = Math.max(ans, val);
            return;
        }

        String curr = String.valueOf(val);
        int m = curr.length();

        for(int i=0; i<m-1; i++){
            for(int j=i+1; j<m; j++){
                if(i==0 && curr.charAt(j)=='0') continue;
                String next = swap(i, j, curr);
                func(cnt+1, Integer.parseInt(next));
            }
        }
    }

    static String swap(int i, int j, String val){
        StringBuilder sb = new StringBuilder();

        for(int l=0; l<val.length(); l++){
            if(l==i){
                sb.append(val.charAt(j));
            }
            else if(l==j){
                sb.append(val.charAt(i));
            }
            else{
                sb.append(val.charAt(l));
            }
        }

        return sb.toString();
    }
}
