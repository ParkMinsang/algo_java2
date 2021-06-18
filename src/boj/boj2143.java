package boj;

import java.io.*;
import java.util.*;

public class boj2143 {
    static int t,n,m;
    static int[] A,B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<m; i++) B[i] = Integer.parseInt(st.nextToken());

        int sizeA = n*(n+1)/2, sizeB = m*(m+1)/2;

        long[] sumA = new long[sizeA];
        long[] sumB = new long[sizeB];

        int idx=0;
        for(int i=0; i<n; i++){
            sumA[idx++]=A[i];
            for(int j=i+1; j<n; j++){
                sumA[idx] = sumA[idx-1]+A[j];
                idx++;
            }
        }
        idx=0;
        for(int i=0; i<m; i++){
            sumB[idx++]=B[i];
            for(int j=i+1; j<m; j++){
                sumB[idx] = sumB[idx-1]+B[j];
                idx++;
            }
        }

        Arrays.sort(sumB);

        long ans=0;
        for(int i=0; i<sizeA; i++){
            int lt=0, rt=sizeB-1, mt=0;
            long tmp = sumA[i];
            int left=0, right=0;
            //왼쪽 경계
            while(lt<=rt){
                mt = (lt+rt)/2;

                if(tmp+sumB[mt] == t){
                    left = mt;
                    rt=mt-1;
                }
                else if(tmp+sumB[mt] > t){
                    rt=mt-1;
                }
                else{
                    lt=mt+1;
                }
            }
            //오른쪽 경계
            lt = left; rt=sizeB-1;
            while(lt<=rt){
                mt = (lt+rt)/2;

                if(tmp+sumB[mt] == t){
                    right = mt;
                    lt = mt+1;
                }
                else if(tmp+sumB[mt] > t){
                    rt=mt-1;
                }
                else{
                    lt=mt+1;
                }
            }
            if(tmp+sumB[left]==t) ans += (right-left)+1;
        }
        System.out.println(ans);
    }
}
