package boj;

import java.io.*;
import java.util.*;

public class boj1167_bfs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] arr = new ArrayList[v+1];
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

        int v1=0, maxdist=0;

        Queue<Edge> q = new LinkedList<>();
        boolean[] isVisited = new boolean[v+1];
        isVisited[1]=true;
        q.add(new Edge(1,0));

        while(!q.isEmpty()){
            Edge curr = q.poll();
            if(curr.w>maxdist){
                maxdist = curr.w;
                v1 = curr.to;
            }

            for(Edge edge : arr[curr.to]){
                if(isVisited[edge.to]) continue;
                isVisited[edge.to]=true;
                q.add(new Edge(edge.to, edge.w+curr.w));
            }
        }

        isVisited = new boolean[v+1];
        isVisited[v1]=true;
        q.add(new Edge(v1, 0));
        int ans=0;
        while(!q.isEmpty()){
            Edge curr = q.poll();
            ans = Math.max(ans, curr.w);

            for(Edge edge : arr[curr.to]){
                if(isVisited[edge.to]) continue;
                isVisited[edge.to]=true;
                q.add(new Edge(edge.to, edge.w+curr.w));
            }
        }
        System.out.println(ans);
    }

    static class Edge{
        int to, w;
        Edge(int to, int w){
            this.to=to;
            this.w=w;
        }
    }
}
