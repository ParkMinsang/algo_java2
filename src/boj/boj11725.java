package boj;

import java.io.*;
import java.util.*;

public class boj11725 {
    static int[] parents;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        arr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) arr[i] = new ArrayList<>();

        StringTokenizer st = null;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr[n1].add(n2);
            arr[n2].add(n1);
        }

        func(1,1);
        StringBuilder sb = new StringBuilder();

        for(int i=2;i<n+1; i++){
            sb.append(parents[i]).append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    static void func(int p, int c){
        if(parents[c]!=0) return;
        parents[c]=p;

        for(int n : arr[c]){
            func(c,n);
        }
    }
}
