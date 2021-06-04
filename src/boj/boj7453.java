package boj;

import java.io.*;
import java.util.*;

public class boj7453 {
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

        Arrays.sort(cd);

        int leng = n*n, lt=0, rt=0, mt=0, lb=0, ub=0;
        long tmp=0, ans=0;
        boolean flag=false;
        for(int i=0; i<leng; i++){
            flag=false;
            lt=0; rt=leng-1;
            while(lt<=rt){
                mt = (lt+rt)/2;
                tmp = ab[i]+cd[mt];
                if(tmp<0){
                    lt=mt+1;
                }else if(tmp>0){
                    rt=mt-1;
                }else{ // tmp==0
                    flag=true;
                    lb=mt;
                    rt=mt-1;
                }
            }

            if(flag){
                lt=lb; rt=leng-1;
                while(lt<=rt){
                    mt = (lt+rt)/2;
                    tmp = ab[i]+cd[mt];
                    if(tmp<0){
                        lt=mt+1;
                    }else if(tmp>0){
                        rt=mt-1;
                    }else{ // tmp==0
                        ub=mt;
                        lt=mt+1;
                    }
                }

                ans+=(ub-lb)+1;
            }
        }
        System.out.println(ans);
    }
}
