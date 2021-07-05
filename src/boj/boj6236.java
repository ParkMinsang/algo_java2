package boj;

import java.io.*;
import java.util.*;

public class boj6236 {
    static int n,m;
    static int[] costs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        costs = new int[n];
        for(int i=0; i<n; i++) costs[i] = Integer.parseInt(br.readLine());

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
        int cnt=0, money=0;

        for(int i=0; i<n; i++){
            if(mt<costs[i]) return false;
            if(money<costs[i]){
                money=mt-costs[i];
                cnt++;
            }else{
                money-=costs[i];
            }
        }
        if(cnt>m) return false;
        return true;
    }
}
