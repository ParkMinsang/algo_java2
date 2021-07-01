package boj;

import java.io.*;
import java.util.*;

public class boj1477 {
    static int n,m,l;
    static boolean[] isBuilt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        isBuilt = new boolean[l];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            isBuilt[Integer.parseInt(st.nextToken())] = true;
        }

        int lt=0, rt=l, mt=0;
        int curr=0, ans=0, cnt=0;
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
        int curr=0;
        int cnt=0;

        for(int i=0; i<l; i++){
            if(isBuilt[i]) curr=i;
            else{
                if(i-curr >= mt){
                    cnt++;
                    curr=i;
                }
            }
        }
        if(l-curr > mt){
            cnt+=(l-curr)/mt;
        }
        if(cnt<=m) return true;
        return false;
    }
}
