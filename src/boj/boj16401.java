package boj;

import java.io.*;
import java.util.*;

public class boj16401 {
    static int n,m;
    static int[] snacks;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        snacks = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) snacks[i] = Integer.parseInt(st.nextToken());

        int lt=0, rt=1000000000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;
            if(isPos(mt)){
                lt=mt+1;
                ans=mt;
            }else{
                rt=mt-1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPos(int mt){
        int cnt=0;
        for(int i=0; i<n; i++){
            cnt+=snacks[i]/mt;
        }
        if(cnt>=m) return true;
        return false;
    }
}
