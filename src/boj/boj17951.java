package boj;

import java.io.*;
import java.util.*;

public class boj17951 {
    static int n, k;
    static int[] scores;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        scores = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        int tot=0;
        for(int i=0; i<n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            tot+=scores[i];
        }

        int lt=0, rt=tot, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

            if(isPos(mt)){
                ans = mt;
                lt=mt+1;
            }else{
                rt=mt-1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPos(int mt){
        int cnt=0, sum=0;
        for(int i=0; i<n; i++){
            sum+=scores[i];
            if(sum>=mt){
                cnt++;
                sum=0;
            }
        }

        if(cnt>=k) return true;
        return false;
    }
}
