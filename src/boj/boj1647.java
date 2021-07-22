package boj;

import java.io.*;
import java.util.*;

public class boj1647 {
    static int[] parents, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) parents[i]=i;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(from, to, w));
        }

        int cnt=0;
        int ans=0;

        while(cnt<n-2 && !pq.isEmpty()){
            Edge edge = pq.poll();

            int from = edge.from;
            int to = edge.to;
            int w = edge.w;

            if(union(from, to)){
                ans+=w;
                cnt++;
            }
        }
        System.out.println(ans);
    }
    static boolean union(int a, int b){
        int arep = findset(a);
        int brep = findset(b);
        if(arep == brep) return false;

        if(rank[arep]>rank[brep]){
            parents[brep]=arep;
        }else if(rank[brep]>rank[arep]){
            parents[arep]=brep;
        }else{
            parents[brep]=arep;
            rank[arep]++;
        }

        return true;
    }
    static int findset(int a){
        if(parents[a]==a) return a;
        return parents[a] = findset(parents[a]);
    }

    static class Edge implements Comparable<Edge>{
        int from, to, w;
        Edge(int from, int to, int w){
            this.from=from;
            this.to=to;
            this.w=w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }

    }
}
