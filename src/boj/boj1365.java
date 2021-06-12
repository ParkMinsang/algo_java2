package boj;

import java.io.*;
import java.util.*;

public class boj1365 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i]=Integer.parseInt(st.nextToken());

        int[] LIS = new int[n];
        int size=0;

        for(int i=0; i<n; i++){
            int idx = Arrays.binarySearch(LIS, 0, size, nums[i]);
            idx = -(idx+1);
            LIS[idx]=nums[i];
            if(idx==size) size++;
        }
        System.out.println(n-size);
    }
}
