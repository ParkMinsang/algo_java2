package boj;

import java.io.*;
import java.util.*;

public class boj17495 {
    static final int INF = 9999999;
    static Map<Character, Integer> map;
    static int n;
    static int[] xys;
    static int[][][] dp;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        map.put('C',0); map.put('D',2); map.put('E',4);
        map.put('F',5); map.put('G',7); map.put('A',9); map.put('B',11);

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int left = xytoi(st.nextToken());
        int right = xytoi(st.nextToken());

        n = Integer.parseInt(br.readLine());
        xys = new int[n];
        dp = new int[n+1][121][121];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            xys[i] = xytoi(st.nextToken());
        }
        for(int i=0; i<n+1; i++){
            for(int j=0; j<121; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        sb = new StringBuilder();
        System.out.println(func(0, left, right));
        output(0,left,right);
        System.out.println(sb);
    }
    static int func(int idx, int left, int right){
        if(idx==n) return 0;
        if(dp[idx][left][right] != -1) return dp[idx][left][right];

        int ret = INF;
        ret = Math.min(ret, Math.abs(left-xys[idx])+func(idx+1, xys[idx], right));
        ret = Math.min(ret, Math.abs(right-xys[idx])+func(idx+1, left, xys[idx]));
        dp[idx][left][right] = ret;
        return dp[idx][left][right];
    }
    static void output(int idx, int left, int right){
        if(idx==n) return;
        int lv = Math.abs(left-xys[idx])+func(idx+1, xys[idx], right);
        int rv = Math.abs(right-xys[idx])+func(idx+1, left, xys[idx]);
        if(lv < rv){
            sb.append("1 ");
            output(idx+1, xys[idx], right);
        }else{
            sb.append("2 ");
            output(idx+1, left, xys[idx]);
        }
    }

    static int xytoi(String xy){
        int ret=0;
        ret += map.get(xy.charAt(0));
        ret += 12*(xy.charAt(1)-'0');
        if(xy.length()==3) ret++;
        return ret;
    }
}
