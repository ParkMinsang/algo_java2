package boj;

import java.io.*;
import java.util.*;

public class boj12101 {
    static int n,k,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cnt=0;
        func(0,new StringBuilder());
        System.out.println(-1);
    }

    static void func(int prev, StringBuilder sb){
        if(prev>n || cnt>k) return;
        if(prev==n){
            cnt++;
            if(cnt==k){
                sb.setLength(sb.length()-1);
                System.out.println(sb);
                System.exit(0);
            }
        }

        for(int i=1; i<4; i++){
            StringBuilder nsb = new StringBuilder();
            nsb.append(sb);
            func(prev+i, nsb.append(i).append('+'));
        }
    }
}
