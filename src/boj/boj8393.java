package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fastSum(n));
    }

    static int fastSum(int n){
        if(n==1) return 1;
        if(n%2==1) return fastSum(n-1)+n;
        return 2*fastSum(n/2)+(n/2)*(n/2);
    }
}
