package boj;

import java.io.*;
import java.util.*;

public class boj2003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i]=Integer.parseInt(st.nextToken());

        int lt=0, rt=0, sum=0, ans=0;
        while(lt<=rt){
            if(sum<m){
                if(rt>=n) break;
                sum+=nums[rt++];
            }else if(sum>m){
                sum-=nums[lt++];
            }else{
                ans++;
                sum-=nums[lt++];
            }
        }
        System.out.println(ans);
    }
}
