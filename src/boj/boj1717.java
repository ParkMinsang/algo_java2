package boj;

import java.io.*;
import java.util.*;

public class boj1717 {
    static int n,m;
    static int[] parents, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i=0; i<n+1; i++) parents[i] = i;
        rank = new int[n+1];

        StringBuilder sb = new StringBuilder();
        int cmd=0, a=0, b=0;
        boolean result=false;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(cmd==0){
                union(a,b);
            }else{
                if(findset(a)==findset(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);

    }
    public static boolean union(int a, int b){
        int arep = findset(a), brep = findset(b);
        if(arep == brep) return false;

        if(rank[arep] > rank[brep]){
            parents[brep]=arep;
        }else if(rank[arep] < rank[brep]){
            parents[arep]=brep;
        }else{
            parents[brep]=arep;
            rank[arep]++;
        }
        return true;
    }

    public static int findset(int a){
        if(parents[a] == a) return a;
        return parents[a]=findset(parents[a]);
    }
}
