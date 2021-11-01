package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n+1];
        int[] need = new int[n+1];
        int[] cnt = new int[n+1];

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) arr[i]=new ArrayList<>();

        for(int i=1; i<n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int time = Integer.parseInt(st.nextToken());
            need[i]=time;

            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next==-1) break;
                cnt[i]++;
                arr[next].add(i);
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=1; i<n+1; i++){
            if(cnt[i]>0) continue;
            pq.add(new Edge(i, need[i]));
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            ans[edge.idx]=edge.tottime;
            for(int next : arr[edge.idx]){
                if(--cnt[next]==0){
                    pq.add(new Edge(next, ans[edge.idx]+need[next]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }
    static class Edge implements Comparable<Edge>{
        int idx, tottime;

        public Edge(int idx, int tottime) {
            this.idx = idx;
            this.tottime = tottime;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "idx=" + idx +
                    ", prevtime=" + tottime +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.tottime, o.tottime);
        }
    }
}
