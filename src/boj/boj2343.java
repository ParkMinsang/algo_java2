package boj;

import java.io.*;
import java.util.*;

public class boj2343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        int lt=0, rt=1000000000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

            int tmp=0, need=1;
            for(int i=0; i<n; i++){
                if(times[i]>mt){
                    need=k+1;
                    break;
                }
                tmp += times[i];
                if(tmp>mt){
                    need++;
                    tmp=times[i];
                }
//                else if(tmp==mt){
//                    tmp=0;
//                    need++;
//                }
            }
//            if(tmp==0) need--;
            if(need<=k){
                ans=mt;
                rt=mt-1;
            }else{
                lt=mt+1;
            }
        }
        System.out.println(ans);
    }
}
