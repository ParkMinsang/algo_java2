package boj;

import java.io.*;
import java.util.*;
/*
fail code
 */
public class boj9329 {
    static int n,m, ans;
    static int[] coupon, price;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            coupon = new int[m+1];
            price = new int[n];
            arr = new ArrayList[n];
            for(int i=0; i<n; i++) arr[i] = new ArrayList<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine()," ");
                int need = Integer.parseInt(st.nextToken());
                for(int j=0; j<need; j++){
                    arr[i].add(Integer.parseInt(st.nextToken()));
                }
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=m; i++){
                coupon[i] = Integer.parseInt(st.nextToken());
            }
            ans=0;
            System.out.println(func(0));
        }
    }
    static int func(int idx){
        if(idx==n) return 0;
        int ret=0;
        if(isPos(idx)){
            for(int k: arr[idx]){
                coupon[k]--;
            }
            ret = Math.max(ret, price[idx]+func(idx));
            for(int k:arr[idx]){
                coupon[k]++;
            }
        }
        ret = Math.max(ret, func(idx+1));

        return ret;
    }

    static boolean isPos(int idx){
        int[] need = new int[m+1];
        for(int k : arr[idx]){
            need[k]++;
        }

        for(int i=1; i<=m; i++){
            if(need[i]>0 && coupon[i]<need[i]){
                return false;
            }
        }

        return true;
    }
}
