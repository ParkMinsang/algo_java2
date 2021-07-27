package boj;

import java.io.*;
import java.util.*;

public class boj1854 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++) arr[i]=new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[from].add(new Edge(to, w));
        }

        ArrayList<Integer>[] ans = new ArrayList[n+1];
        for(int i=1; i<=n; i++) ans[i]=new ArrayList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        for(Edge edge : arr[1]){
//            pq.add(new Edge(edge.to, edge.w));
//        }
        pq.add(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int to=curr.to;
            int w=curr.w;
            if(ans[to].size()>=k) continue;
            ans[to].add(w);

            for(Edge edge : arr[to]){
//                if(ans[edge.to].size()>=k) continue;
                pq.add(new Edge(edge.to, edge.w+w));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(ans[i].size()>=k) sb.append(ans[i].get(k-1));
            else sb.append(-1);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge>{
        int to, w;
        Edge(int to, int w){
            this.to=to;
            this.w=w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }
}
