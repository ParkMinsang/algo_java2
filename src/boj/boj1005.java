package boj;

import java.io.*;
import java.util.*;

public class boj1005 {
    static int n, w;
    static int[] time, dp;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        int k=0, x=0, y=0;
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            time = new int[n];
            dp = new int[n];
            Arrays.fill(dp, -1);
            arr = new ArrayList[n];
            for(int i=0; i<n; i++) arr[i]=new ArrayList<>();

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<n; i++) time[i]=Integer.parseInt(st.nextToken());

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine()," ");
                x = Integer.parseInt(st.nextToken())-1;
                y = Integer.parseInt(st.nextToken())-1;

                arr[y].add(x);
            }
            w = Integer.parseInt(br.readLine())-1;

            System.out.println(func(w));
        }

    }
    static int func(int idx){
        if(arr[idx].size() == 0) return time[idx];
        if(dp[idx] != -1) return dp[idx];

        int ret = 0;
        for(int b : arr[idx]){
            ret = Math.max(ret, time[idx]+func(b));
        }
        dp[idx]=ret;
        return dp[idx];
    }
}
