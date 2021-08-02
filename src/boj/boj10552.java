package boj;

import java.io.*;
import java.util.*;

public class boj10552 {
    static int n,m,p;
    static int[] changeTo;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        changeTo = new int[m+1];
        Arrays.fill(changeTo, -1);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            int fav = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());

            if(changeTo[hate]==-1) changeTo[hate]=fav;
        }

        isVisited = new boolean[m+1];
        System.out.println(func(p,0));
    }
    static int func(int p, int cnt){
        if(isVisited[p]) return -1;
        isVisited[p]=true;

        if(changeTo[p]==-1) return cnt;
        return func(changeTo[p], cnt+1);
    }
}
