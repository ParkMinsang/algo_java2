package boj;

import java.io.*;
import java.util.*;

public class boj2473 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        long ans = (long)nums[0]+nums[1]+nums[2];
        int[] ansarr = new int[3];
        ansarr[0]=nums[0];
        ansarr[1]=nums[1];
        ansarr[2]=nums[2];

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long curr=nums[i]+nums[j];
                int lt=j+1, rt=n-1, mt=0;

                while(lt<=rt){
                    mt=(lt+rt)/2;

                    if(Math.abs(curr+nums[mt]) < Math.abs(ans)){
                        ans = curr+nums[mt];
                        ansarr[0]=nums[i];
                        ansarr[1]=nums[j];
                        ansarr[2]=nums[mt];
                    }
                    if(curr+nums[mt]>=0){
                        rt=mt-1;
                    }else{
                        lt=mt+1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ansarr){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
