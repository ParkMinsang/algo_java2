package boj;

import java.io.*;
import java.util.*;

public class boj13023 {
    static int n,m;
    static boolean[] isVisited;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        isVisited = new boolean[n];

        for(int i=0; i<n; i++){
            isVisited[i]=true;
            func(i,1);
            isVisited[i]=false;
        }
        System.out.println(0);
    }
    static void func(int idx, int cnt){
        if(cnt==5){
            System.out.println(1);
            System.exit(0);
        }

        for(int b : arr[idx]){
            if(isVisited[b]) continue;
            isVisited[b]=true;
            func(b, cnt+1);
            isVisited[b]=false;
        }
    }
}
