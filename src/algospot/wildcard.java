package algospot;

import java.io.*;
import java.util.*;

public class wildcard {
    static String w, s;
    static int[][] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        PriorityQueue<String> pq = null;

        for(int tc=0; tc<c; tc++){
            w = br.readLine();
            int n = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();

            for(int i=0; i<n; i++){
                s = br.readLine();

                dp = new int[s.length()][w.length()];
                for(int j=0; j<s.length(); j++) Arrays.fill(dp[j], -1);

                if(func(0,0)>0) pq.add(s);
            }
            while(!pq.isEmpty()){
                String ans = pq.poll();
                sb.append(ans).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int func(int idx1, int idx2){
//        System.out.println(idx1+" "+idx2);

        if(idx1>=s.length()){
            if(idx2>=w.length()) return 1;
            else if(w.charAt(idx2)=='*') return func(idx1, idx2+1);
            else return 0;
        }else if(idx2>=w.length()) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int ret=0;
        char c1 = s.charAt(idx1);
        char c2 = w.charAt(idx2);

        if(c1==c2 || c2=='?'){
            ret += func(idx1+1, idx2+1);
        }else if(c2=='*'){
            for(int i=idx1; i<=s.length(); i++){
                ret += func(i, idx2+1);
            }
        }
        dp[idx1][idx2]=ret;
        return dp[idx1][idx2];
    }
}
