package boj;

import java.io.*;
import java.util.*;

public class boj1956 {
    static final int INF = 99999999;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] floyd = new int[v+1][v+1];
        for(int i=0; i<v+1; i++) Arrays.fill(floyd[i], INF);

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            floyd[from][to] = w;
        }

        for(int k=1; k<v+1; k++){
            for(int s=1; s<v+1; s++){
                for(int d=1; d<v+1; d++){
                    floyd[s][d] = Math.min(floyd[s][d], floyd[s][k]+floyd[k][d]);
                }
            }
        }

        int ans = INF;
        for(int i=1; i<v+1; i++){
            ans = Math.min(ans, floyd[i][i]);
        }
        System.out.println(ans==INF?-1:ans);
    }
}
