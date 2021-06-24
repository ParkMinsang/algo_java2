package boj;

import java.io.*;
import java.util.*;

public class boj15649 {
    static int n,m;
    static boolean[] isSelected;
    static int[] perm;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isSelected = new boolean[n];
        perm = new int[m];

        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int idx){
        if(idx==m){
            for(int i=0; i<m; i++){
                sb.append(perm[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(!isSelected[i]){
                isSelected[i]=true;
                perm[idx]=i+1;
                permutation(idx+1);
                isSelected[i]=false;
            }
        }
    }
}
