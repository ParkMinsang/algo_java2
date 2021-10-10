package boj;

import java.io.*;
import java.util.*;

public class boj11657 {
    static final int INF = 5000001;
    static int n,m;
    static long[] dist;
    static Edge[] edges;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new Edge[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int val = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, val);
        }

        dist = new long[n];
        Arrays.fill(dist, INF);

        int start=0;
        if(bellmanford(start)){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<n; i++){
                sb.append(dist[i]==INF?-1:dist[i]);
                sb.append('\n');
            }
            System.out.println(sb);
        }

    }
    static boolean bellmanford(int start){
        dist[start]=0;

        for(int t=0; t<n; t++){
            for(int i=0; i<m; i++){
                Edge curr = edges[i];

                int from=curr.from;
                int to=curr.to;
                int val=curr.val;

                if(dist[from]!=INF && dist[from]+val < dist[to]){
                    dist[to]=dist[from]+val;
                    if(t==n-1) return true;
                }
            }
        }

        return false;
    }
}

class Edge{
    int from, to, val;

    Edge(int from, int to, int val){
        this.from=from;
        this.to=to;
        this.val=val;
    }
}