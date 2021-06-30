package boj;

import java.io.*;

public class boj9882 {
    static int[] cows;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cows = new int[12];
        for(int i=0; i<12; i++){
            cows[i] = Integer.parseInt(br.readLine());
        }
        ans = 99999999;
        func(0,0,0,0,0,0,0,0,0);
        System.out.println(ans);
    }
    static void func(int idx, int t1, int t2, int t3, int t4, int s1, int s2, int s3, int s4){
        if(idx==12){
            int maxc = Math.max(s1, s2);
            maxc = Math.max(maxc,s3);
            maxc = Math.max(maxc,s4);
            int minc = Math.min(s1,s2);
            minc = Math.min(minc, s3);
            minc = Math.min(minc, s4);

            ans = Math.min(ans, maxc-minc);
            return;
        }

        if(t1<3){
            func(idx+1, t1+1, t2,t3,t4,s1+cows[idx], s2, s3,s4);
        }
        if(t2<3){
            func(idx+1, t1, t2+1, t3,t4, s1, s2+cows[idx], s3,s4);
        }
        if(t3<3){
            func(idx+1, t1,t2,t3+1, t4, s1,s2,s3+cows[idx],s4);
        }
        if(t4<3){
            func(idx+1, t1,t2,t3,t4+1, s1,s2,s3,s4+cows[idx]);
        }
    }
}
