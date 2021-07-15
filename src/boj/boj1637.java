package boj;

import java.io.*;
import java.util.*;

public class boj1637 {
    static int n;
    static long ans,anscnt;
    static long[][] abc;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        abc = new long[n][3];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            abc[i][0] = Long.parseLong(st.nextToken());
            abc[i][1] = Long.parseLong(st.nextToken());
            abc[i][2] = Long.parseLong(st.nextToken());
        }

        ans=-1;
        long lt=1, rt=Integer.MAX_VALUE, mt=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

            long ret=isPos(mt);

            if(ret%2!=0){
                ans = mt;
                anscnt=ret;
                rt=mt-1;
            }else{
                lt=mt+1;
            }
        }
        if(ans==-1){
            System.out.println("NOTHING");
            System.exit(0);
        }

        lt=1; rt=ans; mt=0;
        long before=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

            long ret=isPos(mt);

            if(ret%2==0){
                before=ret;
                lt=mt+1;
            }else{
                rt=mt-1;
            }
        }
        System.out.println(ans+" "+(anscnt-before));
    }
    static long isPos(long mt){
        long ret=0;
        for(int i=0; i<n; i++){
            long lm = Math.min(abc[i][1], mt);
            if(lm<abc[i][0]) continue;
            ret += ((lm-abc[i][0])/abc[i][2])+1;
        }
        return ret;
    }
}
