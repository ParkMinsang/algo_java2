package boj;

import java.io.*;
import java.util.*;
import java.math.*;

public class boj8595 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long ans=0, prev=0;

        for(int i=0; i<n; i++){
            char c = input.charAt(i);
            if(c>'9' || c<'0'){
                ans+=prev;
                prev=0;
            }else{
                prev*=10;
                prev+=c-'0';
            }
        }
        ans+=prev;

        System.out.println(ans);
    }
}
