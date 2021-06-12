package boj;

import java.io.*;
import java.util.*;

public class boj2467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] val = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            val[i] = Integer.parseInt(st.nextToken());
        }

        int lt=0,rt=0,mt=0,min=0,max=0, closest=Integer.MAX_VALUE, tmp=0;
        for(int i=0; i<n-1; i++){
            lt = i+1; rt=n-1;
            while(lt<=rt){
                mt=(lt+rt)/2;

                tmp = val[i]+val[mt];
                if(Math.abs(tmp) < Math.abs(closest)){
                    closest = tmp;
                    min=val[i]; max=val[mt];
                }

                if(tmp<0){
                    lt=mt+1;
                }else if(tmp>0){
                    rt=mt-1;
                }else{
                    System.out.println(min+" "+max);
                    System.exit(0);
                }
            }
        }
        System.out.println(min+" "+max);
    }
}
