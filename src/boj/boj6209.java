package boj;

import java.io.*;
import java.util.*;

public class boj6209 {
    static int n,m,d;
    static int[] stones;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stones = new int[n];
        for(int i=0; i<n; i++){
            stones[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(stones);

        int lt=0,rt=d,mt=0,ans=0;
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
        int cnt=0, prev=0;
        for(int i=0; i<n; i++){
            if(stones[i]-prev>=mt){
                prev=stones[i];
            }else{
                cnt++;
                if(cnt>m) return false;
            }
        }
        if(d-prev<mt || cnt>m) return false;
        return true;
    }
}
