package boj;

import java.io.*;
import java.util.*;

public class boj9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            for(int j=0; j<n; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;

            for(int s=0; s<n; s++){
                for(int e=s+1; e<n; e++){
                    ans+=getGCD(nums[s], nums[e]);
                }
            }
            System.out.println(ans);
        }
    }

    static int getGCD(int a, int b){
        if(a%b==0) return b;
        return getGCD(b, a%b);
    }
}
