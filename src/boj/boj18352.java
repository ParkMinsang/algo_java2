package boj;

import java.io.*;
import java.util.*;

public class boj18352 {
    static final int INF = 300001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] dist = new int[n];
        boolean[] isVisited = new boolean[n];
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=1; i<n; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
        }

        Arrays.fill(dist, INF);
        dist[x]=0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(x,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(isVisited[curr.to]) continue;
            isVisited[curr.to]=true;

            for(int next : arr[curr.to]){
                if(isVisited[next]) continue;
                if(dist[next] > dist[curr.to]+1 && dist[curr.to]+1 <= k){
                    dist[next]=dist[curr.to]+1;
                    pq.add(new Edge(next, dist[next]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n; i++){
            if(dist[i]==k) sb.append(i).append('\n');
        }

        System.out.println(sb.length()==0?-1:sb);
    }
    static class Edge implements Comparable<Edge>{
        int to, w;
        Edge(int to, int w){
            this.to= to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }
}
