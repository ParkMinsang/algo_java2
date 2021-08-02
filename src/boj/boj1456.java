package boj;

import java.io.*;
import java.util.*;
import java.math.*;

public class boj1456 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        boolean[] isPrime = new boolean[10000001];

        int cnt=0;
        for(int i=2; i<=10000000; i++){
            if(!isPrime[i]){
                BigInteger tmp = new BigInteger(Long.toString((long)i*i));
                if(tmp.compareTo(b)==1) break;
                while(tmp.compareTo(b)!=1){
                    if(tmp.compareTo(a)!=-1) cnt++;
                    tmp = tmp.multiply(new BigInteger(Integer.toString(i)));
                }
                int j=i+i;
                while(j<=10000000){
                    isPrime[j]=true;
                    j+=i;
                }
            }
        }
        System.out.println(cnt);
    }
}
