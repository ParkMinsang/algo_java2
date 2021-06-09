package boj;

import java.io.*;
import java.util.*;

public class boj2572 {
    static int n,m,k;
    static int[][] dp;
    static char[] colors;
    static ArrayList<To>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        colors = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            colors[i] = st.nextToken().charAt(0);
        }
        st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[m];
        for(int i=0; i<m; i++) arr[i] = new ArrayList<>();

        int from=0, to=0;
        char currc='0';
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            from = Integer.parseInt(st.nextToken())-1;
            to = Integer.parseInt(st.nextToken())-1;
            currc = st.nextToken().charAt(0);

            arr[from].add(new To(to, currc));
            arr[to].add(new To(from, currc));
        }

        dp = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0,0));
    }
    static int func(int idx, int from){
        if(idx==n) return 0;
        if(dp[idx][from] != -1) return dp[idx][from];

        int ret=0;
        for(To to : arr[from]){
            if(colors[idx]==to.color){
                ret=Math.max(ret, 10+func(idx+1, to.num));
            }else{
                ret=Math.max(ret, func(idx+1, to.num));
            }
        }
        dp[idx][from]=ret;
        return dp[idx][from];
    }

    static class To{
        int num;
        char color;
        To(int num, char color){
            this.num = num;
            this.color = color;
        }
    }
}
