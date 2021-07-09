package boj;

import java.io.*;
import java.util.*;

public class boj11729 {
    static int ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ans=0;
        sb = new StringBuilder();
        func(n,1,3,2);
        System.out.println(ans);
        System.out.println(sb);
    }
    static void func(int h, int s, int d, int t){
        if(h==0) return;
        ans++;
        func(h-1, s, t, d);
        sb.append(s).append(" ").append(d).append("\n");
        func(h-1, t, d, s);
    }
}
