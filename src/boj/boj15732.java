package boj;

import java.io.*;
import java.util.*;

public class boj15732 {
    static int n,k,d;
    static int[][] rules;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        rules = new int[k][3];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            rules[i][0]=s;
            rules[i][1]=e;
            rules[i][2]=l;
        }

        int lt=0, rt=n, mt=0, ans=0;
        while(lt<=rt){
            mt=(lt+rt)/2;
            if(isPos(mt)){
                ans=mt;
                rt=mt-1;
            }else{
                lt=mt+1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPos(int mt){
        long cnt=0;
        for(int i=0; i<k; i++){
            int start=rules[i][0];
            int end=Math.min(rules[i][1], mt);
            int l = rules[i][2];

            if(start>mt) continue;

            int curr = end-start;
            cnt+=(curr/l)+1;
        }
        if(cnt>=d) return true;
        return false;
    }
}
