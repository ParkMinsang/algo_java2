package boj;

import java.io.*;
import java.util.*;

public class boj10971_2 {
    static int n, ans;
    static boolean[] isSelected;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        isSelected = new boolean[n];
        StringTokenizer st = null;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans=99999999;
        isSelected[0]=true;
        permutation(1, 0, 0);
        System.out.println(ans);

    }

    public static void permutation(int idx, int prev, int cost){
        if(cost>=ans) return;
        if(idx==n){
            if(dist[prev][0]==0) return;
            ans = Math.min(ans, cost+dist[prev][0]);
            return;
        }

        for(int i=0; i<n; i++){
            if(!isSelected[i]){
                if(dist[prev][i]==0) continue;
                isSelected[i] = true;
                permutation(idx+1, i, cost+dist[prev][i]);
                isSelected[i] = false;
            }
        }
    }

}
