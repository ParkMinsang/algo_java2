package boj;

import java.io.*;
import java.util.*;

public class boj21758 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sum=0, maxval=0;
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum+=nums[i];
            if(i!=0 && i!=n-1) maxval = Math.max(maxval, nums[i]);
        }
        //벌, 벌통, 벌
        int ans = sum-nums[0]-nums[n-1]+maxval;

        //벌, 벌, 벌통
        int b1tmp=0, b2tmp=0;
        int prevtmp=nums[1]*2;
        int tmp = (sum-nums[0])*2;
        for(int i=1; i<n-1; i++){
            b1tmp = nums[i];
            b2tmp += nums[i];
            ans = Math.max(ans, tmp-b1tmp-b2tmp);
        }

        //벌통, 벌, 벌
        prevtmp = nums[n-2]*2;
        b1tmp=0; b2tmp=0;
        tmp = (sum-nums[n-1])*2;
        for(int i=n-2; i>0; i--){
            b1tmp=nums[i];
            b2tmp+=nums[i];
            ans = Math.max(ans, tmp-b1tmp-b2tmp);
        }

        System.out.println(ans);
    }
}
