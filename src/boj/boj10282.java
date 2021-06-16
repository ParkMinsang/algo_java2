package boj;

import java.io.*;
import java.util.*;

public class boj10282 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int n=0, d=0,c=0, a=0, b=0, s=0, size=0, ansc=0, anst=0;

        ArrayList<Edge>[] arr = null;
        PriorityQueue<Edge> pq = null;
        for(int tc=0; tc<TC; tc++){
            ansc=0; anst=0;
            st = new StringTokenizer(br.readLine()," ");

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n+1];
            for(int i=1; i<n+1; i++) arr[i] = new ArrayList<>();

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine()," ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                arr[b].add(new Edge(a,s));
            }

            boolean[] isVisited = new boolean[n+1];
            isVisited[c]=true;
            ansc=1;
            pq = new PriorityQueue<>();
            for(Edge edge : arr[c]){
                pq.add(new Edge(edge.to, edge.time));
            }

            while(!pq.isEmpty()){
                Edge curr = pq.poll();
                if(isVisited[curr.to]) continue;

                isVisited[curr.to]=true;
                ansc++;
                anst = Math.max(anst, curr.time);

                for(Edge edge : arr[curr.to]){
                    if(isVisited[edge.to]) continue;
                    pq.add(new Edge(edge.to, curr.time+edge.time));
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ansc).append(" ").append(anst);
            System.out.println(sb);
        }


    }
    static class Edge implements Comparable<Edge>{
        int to, time;
        Edge(int to, int time){
            this.to=to;
            this.time=time;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
