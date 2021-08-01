package boj;

import java.io.*;
import java.util.*;

public class boj1162 {
    static final long INF = 10000000001L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] arr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            arr[from].add(new Edge(to, w, 0));
            arr[to].add(new Edge(from, w, 0));
        }

        long[][] dist = new long[n+1][k+1];

        for(int i=0; i<n+1; i++){
            Arrays.fill(dist[i], INF);
        }
        dist[1][0]=0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(dist[curr.to][curr.cnt] < curr.w) continue;

            for(Edge edge : arr[curr.to]){
                if(dist[edge.to][curr.cnt] > dist[curr.to][curr.cnt]+edge.w){
                    dist[edge.to][curr.cnt] = dist[curr.to][curr.cnt]+edge.w;
                    pq.add(new Edge(edge.to, dist[edge.to][curr.cnt], curr.cnt));
                }

                if(curr.cnt < k && dist[edge.to][curr.cnt+1] > dist[curr.to][curr.cnt]){
                    dist[edge.to][curr.cnt+1] = dist[curr.to][curr.cnt];
                    pq.add(new Edge(edge.to, dist[edge.to][curr.cnt+1], curr.cnt+1));
                }
            }
        }

        long ans = INF;
        for(int i=0; i<=k; i++) ans = Math.min(ans, dist[n][i]);
        System.out.println(ans);
    }

    static class Edge implements Comparable<Edge>{
        int to, cnt;
        long w;
        Edge(int to, long w, int cnt){
            super();
            this.to=to;
            this.w=w;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Edge o){
            return Long.compare(this.w, o.w);
        }
    }
}
