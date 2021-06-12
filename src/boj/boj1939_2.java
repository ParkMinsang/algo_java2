package boj;

import java.io.*;
import java.util.*;

public class boj1939_2 {
    static int[] parents, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(f,t,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i=1; i<n+1; i++) parents[i]=i;
        rank = new int[n+1];

        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(findset(curr.from)==findset(curr.to)) continue;

            union(curr.from, curr.to);
            ans = Math.min(ans, curr.w);
            if(findset(s) == findset(e)) break;
        }

        System.out.println(ans);

    }
    static boolean union(int a, int b){
        int arep = findset(a);
        int brep = findset(b);

        if(arep==brep) return false;

        if(rank[arep] > rank[brep]){
            parents[brep] = arep;
        }else if(rank[arep] < rank[brep]){
            parents[arep] = brep;
        }else{
            parents[brep] = arep;
            rank[arep]++;
        }
        return true;
    }

    static int findset(int a){
        if(a == parents[a]) return a;
        return parents[a] = findset(parents[a]);
    }

    static class Edge implements Comparable<Edge>{
        int from,to,w;
        Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.w, this.w);
        }
    }
}
