package boj;

import java.io.*;
import java.util.*;

public class boj1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i]=Integer.parseInt(st.nextToken());

        int s=0, e=1;
        int sum=nums[0], leng=1, ans=n+1;
        while(s<=e){
            if(sum >= S){
                ans = Math.min(ans, leng);
                sum -= nums[s];
                leng--;
                s++;
            }else{
                if(e==n) break;
                sum += nums[e];
                leng++;
                e++;
            }
        }
        System.out.println(ans==n+1?0:ans);
    }
}
