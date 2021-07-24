package boj;

import java.io.*;

public class boj1789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        s<<=1;
        long i=1;
        while(i*(i+1) <= s){
            i++;
        }
        System.out.println(i-1);
    }
}
