package boj;

import java.io.*;
import java.util.*;

public class boj1167_dfs {
    static int v, deepone, maxdist;
    static boolean[] isVisited;
    static ArrayList<Edge>[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        v = Integer.parseInt(br.readLine());
        arr = new ArrayList[v+1];
        for(int i=1; i<v+1; i++) arr[i]=new ArrayList<>();

        for(int i=0; i<v; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());

            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to==-1) break;
                int w = Integer.parseInt(st.nextToken());

                arr[from].add(new Edge(to, w));
            }
        }

        maxdist = 0;
        isVisited = new boolean[v+1];
        findfar(1, 0);
        isVisited = new boolean[v+1];
        findfar(deepone, 0);
        System.out.println(maxdist);
    }
    static void findfar(int idx, int prev){
        isVisited[idx]=true;
        if (prev > maxdist) {
            maxdist = prev;
            deepone = idx;
        }

        for(Edge next : arr[idx]){
            if(isVisited[next.to]) continue;
            findfar(next.to, prev+next.w);
        }
    }

    static class Edge{
        int to, w;
        Edge(int to, int w){
            this.to=to;
            this.w=w;
        }
    }
}
