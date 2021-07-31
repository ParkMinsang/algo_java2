package boj;

import java.io.*;

public class boj2581 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        if(m==1) m = 2;
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n+1];

        for(int i=2; i<n; i++){
            if(!isPrime[i]){
                int j=i+i;
                while(j<=n){
                    isPrime[j]=true;
                    j+=i;
                }
            }
        }
        int sum=0;
        int cnt=0;
        int minans=0;
        for(int i=m; i<=n; i++){
            if(!isPrime[i]){
                sum+=i;
                if(cnt==0){
                    cnt++;
                    minans=i;
                }
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(minans);
        }

    }
}
