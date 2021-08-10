package jongmanbook.ch28;

import java.util.*;

public class 위상정렬dfs {
    static StringBuilder sb;
    static boolean[] isVisited;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) {
        isVisited = new boolean[11];
        adj = new ArrayList[11];
        for(int i=0; i<11; i++) adj[i]=new ArrayList<>();

        adj[6].add(7);
        adj[6].add(8);
        adj[6].add(9);
        adj[7].add(1);
        adj[1].add(2);
        adj[8].add(2);
        adj[2].add(3);
        adj[10].add(3);
        adj[9].add(4);
        adj[3].add(4);
        adj[4].add(5);

        sb = new StringBuilder();
        dfsAll();
        System.out.println(sb);
    }
    static void dfsAll(){
        for(int i=1; i<11; i++){
            if(isVisited[i]) continue;
            dfs(i);
        }
    }

    static void dfs(int here){
        isVisited[here]=true;

        for(int there : adj[here]){
            if(isVisited[there]) continue;
            dfs(there);
        }
        sb.append(here).append(' ');
    }
}
