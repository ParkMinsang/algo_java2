package boj;

import java.io.*;
import java.util.*;

public class boj2295 {
    static int n;
    static int[] nums;
    static boolean[] isInNums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        isInNums = new boolean[20000001];

        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            isInNums[nums[i]]=true;
        }
        Arrays.sort(nums);

        for(int i=n-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                int curr = nums[i]+nums[j];
                if(curr>=20000000) continue;
                for(int k=j; k>=0; k--){
                    if(curr+nums[k]>20000000) continue;
                    if(isInNums[curr+nums[k]]){
                        System.out.println(curr+nums[k]);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
