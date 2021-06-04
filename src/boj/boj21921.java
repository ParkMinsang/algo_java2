package boj;

import java.io.*;
import java.util.*;

public class boj21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visit = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int maxval=0, maxcnt=1, currval=0;
        for(int i=0; i<x; i++){
            maxval += visit[i];
        }
        currval = maxval;

        for(int i=x; i<n; i++){
            currval -= visit[i-x];
            currval += visit[i];
            if(currval == maxval) maxcnt++;
            else if(currval > maxval){
                maxval = currval;
                maxcnt = 1;
            }
        }

        if(maxval == 0){
            System.out.println("SAD");
        }else{
            System.out.println(maxval);
            System.out.println(maxcnt);
        }
    }
}
