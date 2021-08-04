package boj;

import java.io.*;
import java.util.*;

public class boj16437 {
    static ArrayList<Integer>[] arr;
    static int[] sheep;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        sheep = new int[n+1];
        for(int i=1; i<n+1; i++) arr[i]=new ArrayList<>();

        for(int i=2; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");

            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(t=='W') sheep[i]=-a;
            else sheep[i]=a;

            arr[p].add(i);
        }

        System.out.println(func(1));
    }
    static long func(int idx){
        long ret=sheep[idx];

        for(Integer conn : arr[idx]){
            ret += func(conn);
        }

        return ret>0?ret:0;
    }
}
