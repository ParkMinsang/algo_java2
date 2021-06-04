package boj;

import java.io.*;
import java.util.*;
/*
 * 시간초과
 */
public class boj7453_2 {
    static int n;
    static long[] a,b,c,d, ab;
    static Map<Long, Integer> cd;
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

        ab = new long[n*n]; cd = new HashMap<>();
        int idx=0;
        long tmp=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[idx] = a[i]+b[j];
                tmp = c[i]+d[j];
                if(cd.get(tmp)==null){
                    cd.put(tmp,1);
                }else{
                    cd.put(tmp, cd.get(tmp)+1);
                }
                idx++;
            }
        }

        int leng = n*n;
        long ans=0;
        for(int i=0; i<leng; i++){
            if(cd.get(-ab[i]) != null){
                ans+=cd.get(-ab[i]);
            }
        }

        System.out.println(ans);
    }
}
