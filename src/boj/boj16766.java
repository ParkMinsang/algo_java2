package boj;

import java.io.*;
import java.util.*;

public class boj16766  {
    static int n,m,c;
    static int[] cows;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cows = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) cows[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cows);

        int lt=0, rt=1000000000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

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
        int cnt=0, onbus=0, prev=0;
        for(int i=0; i<n; i++){
            if(onbus==0){
                onbus=1;
                prev=cows[i];
            }
            else{
                if(cows[i]-prev>mt){
                    cnt++;
                    prev=cows[i];
                    onbus=1;
                }else{
                    onbus++;
                }
            }
            if(onbus==c){
                cnt++;
                onbus=0;
            }
        }
        if(onbus>0) cnt++;

        if(cnt>m) return false;
        return true;
    }
}
