package boj;

import java.io.*;
import java.util.*;

public class boj1939 {
    static int[] parents, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(f,t,w);
        }
        st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = null;
        int lt=0, rt=1000000000, mt=0, ans=0;
        while(lt<=rt){
            parents = new int[n+1];
            for(int i=1; i<n+1; i++) parents[i]=i;
            rank = new int[n+1];
            pq = new PriorityQueue<>();
            for(int i=0; i<m; i++) pq.add(edges[i]);
            mt = (lt+rt)/2;

            while(!pq.isEmpty()){
                Edge curr = pq.poll();
                if(curr.w < mt) continue;

                union(curr.from, curr.to);
                if(findset(s) == findset(e)) break;
            }
            if(findset(s) == findset(e)){
                ans = mt;
                lt=mt+1;
            }else{
                rt=mt-1;
            }
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
            return Integer.compare(this.w, o.w);
        }
    }
}
