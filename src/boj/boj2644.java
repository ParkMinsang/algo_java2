package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[n];
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        isVisited[a]=true;
        q.add(a);

        int cycle=0, size=0;
        while(!q.isEmpty()){
            if(isVisited[b]) break;
            cycle++;
            size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();

                for(int next : arr[curr]){
                    if(isVisited[next]) continue;
                    isVisited[next]=true;
                    q.add(next);
                }
            }
        }
        System.out.println(isVisited[b]?cycle:-1);

    }
}
