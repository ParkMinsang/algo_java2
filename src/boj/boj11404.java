package boj;

import java.io.*;
import java.util.*;

public class boj11404 {
    static final int INF = 99999999;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        int[][] adj = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(adj[i], INF);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a][b]=Math.min(adj[a][b],c);
        }

        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(i==j) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(adj[i][j]==INF) sb.append(0).append(' ');
                else sb.append(adj[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
