package boj;

import java.io.*;
import java.util.*;

public class boj1922 {
    static int n;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=0; i<n+1; i++) parent[i] = i;
        rank = new int[n+1];

        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        for(int i=0;i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(from, to, cost));
        }

        int connected = 0, ans=0;
        while(connected < n-1){
            Edge edge = pq.poll();
            if(!union(edge.from, edge.to)) continue;
            connected++;
            ans += edge.cost;
        }

        System.out.println(ans);
    }


    public static boolean union(int a, int b){
        int aset = findset(a);
        int bset = findset(b);

        if(aset == bset) return false;

        if(rank[aset] > rank[bset]){
            parent[bset] = aset;
        }else if(rank[aset] < rank[bset]){
            parent[aset] = bset;
        }else{
            parent[bset] = aset;
            rank[aset]++;
        }
        return true;
    }

    public static int findset(int a){
        if(a == parent[a]) return a;
        return parent[a] = findset(parent[a]);
    }

    public static class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cost){
            super();
            this.from = from;
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
}
