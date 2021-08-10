package boj;

import java.io.*;
import java.util.*;

public class boj2252 {
    static StringBuilder sb;
    static boolean[] isVisited;
    static int n,m;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        adj = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) adj[i]=new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[b].add(a);
        }
        sb = new StringBuilder();
        dfsAll();
        System.out.println(sb);
    }
    static void dfsAll(){
        for(int i=1; i<n+1; i++){
            if(isVisited[i]) continue;
            dfs(i);
        }
    }
    static void dfs(int tall){
        isVisited[tall]=true;

        for(int small : adj[tall]){
            if(isVisited[small]) continue;
            dfs(small);
        }
        sb.append(tall).append(' ');
    }
}
