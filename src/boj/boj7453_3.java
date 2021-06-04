package boj;

import java.io.*;
import java.util.*;

public class boj7453_3 {
    static int n;
    static long[] a,b,c,d, ab, cd;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new long[n]; b=new long[n]; c=new long[n]; d=new long[n];
        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            a[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
            c[i] = Long.parseLong(st.nextToken());
            d[i] = Long.parseLong(st.nextToken());
        }

        ab = new long[n*n]; cd = new long[n*n];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[idx] = a[i]+b[j];
                cd[idx] = c[i]+d[j];
                idx++;
            }
        }

        Arrays.sort(cd); Arrays.sort(ab);

        long ans=0, tmp=0, leng=n*n, abtmp=0, cdtmp=0, abcnt=0, cdcnt=0;
        int abidx=0, cdidx=n*n-1;
        while(abidx<leng && cdidx>=0){
            tmp = ab[abidx]+cd[cdidx];
            if(tmp>0) cdidx--;
            else if(tmp<0) abidx++;
            else{
                abtmp=ab[abidx]; cdtmp=cd[cdidx]; abcnt=0; cdcnt=0;
                while(abidx<leng && ab[abidx]==abtmp){
                    abidx++;
                    abcnt++;
                }
                while(cdidx>=0 && cd[cdidx]==cdtmp){
                    cdidx--;
                    cdcnt++;
                }

                ans+=abcnt*cdcnt;
            }
        }
        System.out.println(ans);
    }
}
