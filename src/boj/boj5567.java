package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5567 {
    static int ans;
    static boolean[] isVisited;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i]=new ArrayList<>();

        isVisited = new boolean[n];

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            arr[a].add(b);
            arr[b].add(a);
        }

        ans = 0;
        isVisited[0]=true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int cycle=0;
        while(!q.isEmpty()){
            if(cycle==3) break;
            cycle++;
            int size = q.size();

            for(int s=0; s<size; s++){
                int curr = q.poll();
                ans++;
                for(int next : arr[curr]){
                    if(isVisited[next]) continue;
                    isVisited[next]=true;
                    q.add(next);
                }
            }
        }
        System.out.println(ans-1);
    }
}
