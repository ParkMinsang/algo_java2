package boj;

import java.io.*;
import java.util.*;

public class boj1766 {
    static StringBuilder sb;
    static boolean[] isVisited;
    static int n,m;
    static int[] need;
    static ArrayList<Integer>[] arr;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        need = new int[n+1];
        Arrays.fill(need, 0);
        arr = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) arr[i]=new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            need[b]++;
        }

        pq = new PriorityQueue<>();

        for(int i=1; i<=n; i++) if(need[i]==0) pq.add(i);

        sb = new StringBuilder();

        while(!pq.isEmpty()){
            int curr = pq.poll();
            sb.append(curr).append(' ');

            for(int next : arr[curr]){
                if(--need[next]==0){
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
