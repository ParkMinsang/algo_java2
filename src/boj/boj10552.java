package boj;

import java.io.*;
import java.util.*;

public class boj10552 {
    static int n,m,p;
    static int[] fav, hate;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken())-1;

        fav = new int[n];
        hate = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            int fa = Integer.parseInt(st.nextToken())-1;
            int ha = Integer.parseInt(st.nextToken())-1;

            fav[i]=fa;
            hate[i]=ha;
        }

        isVisited = new boolean[m];

        func(p,0);
    }
    static void func(int p, int cnt){
        if(isVisited[p]){
            System.out.println(-1);
            System.exit(0);
        }
        isVisited[p]=true;

        for(int i=0; i<n; i++){
            if(hate[i]==p){
                func(fav[i], cnt+1);
                return;
            }
        }
        System.out.println(cnt);
    }
}
