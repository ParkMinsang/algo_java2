package boj;

import java.io.*;
import java.util.*;

public class boj15591 {
    static final long INF = 510000000000L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i]=new ArrayList<>();

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            arr[s].add(new Edge(e,w));
            arr[e].add(new Edge(s,w));
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken())-1;

            int ans=0;
            boolean[] isVisited = new boolean[n];
            isVisited[v] = true;
            Queue<Edge> edgeq = new LinkedList<>();
            for(Edge edge : arr[v]){
                isVisited[edge.to]=true;
                if(edge.w >= k) {
                    edgeq.add(new Edge(edge.to, edge.w));
                }
            }
            while(!edgeq.isEmpty()){
                ans++;
                Edge curr = edgeq.poll();

                for(Edge edge : arr[curr.to]){
                    if(!isVisited[edge.to] && edge.w >= k){
                        isVisited[edge.to]=true;
                        edgeq.add(new Edge(edge.to, edge.w));
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class Edge{
        int to, w;
        Edge(int to, int w){
            super();
            this.to=to;
            this.w=w;
        }
    }
}
