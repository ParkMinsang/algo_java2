package boj;

import java.io.*;
import java.util.*;

public class boj14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        int size=0;
        int[] lis = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int idx = Arrays.binarySearch(lis, 0, size, nums[i]);
            if(idx>=0){
                ans[i] = idx;
                continue;
            }
            else{
                idx = -(idx+1);
                lis[idx]=nums[i];
                ans[i] = idx;
                if(idx==size) {
                    size++;
                }
            }
        }
        System.out.println(size);
        StringBuilder sb = new StringBuilder();
        int aidx=size-1;
        int[] rans= new int[size];
        for(int i=n-1; i>=0; i--){
            if(ans[i]==aidx){
                rans[aidx] = nums[i];
                aidx--;
                if(aidx<0) break;
            }
        }
        for(int i=0; i<size; i++){
            sb.append(rans[i]).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
