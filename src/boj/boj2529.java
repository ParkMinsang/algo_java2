package boj;

import java.io.*;
import java.util.*;

public class boj2529 {
    static int k;
    static String minans, maxans;
    static boolean isFindmin, isFindmax;
    static boolean[] isSelected;
    static int[] nums;
    static char[] opes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        opes = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<k; i++){
            opes[i] = st.nextToken().charAt(0);
        }

        nums = new int[k+1];
        isFindmin = false;
        isFindmax = false;

        isSelected = new boolean[10];
        findminans(0);

        isSelected = new boolean[10];
        findmaxans(0);

        System.out.println(maxans);
        System.out.println(minans);
    }
    static void findminans(int idx){
        if(isFindmin) return;
        if(idx==k+1) {
            if(isGoodnum()){
                isFindmin = true;
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<k+1; i++){
                    sb.append(nums[i]);
                }
                minans = sb.toString();
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                nums[idx]=i;
                findminans(idx+1);
                isSelected[i] = false;
            }
        }
    }
    static void findmaxans(int idx){
        if(isFindmax) return;
        if(idx==k+1) {
            if(isGoodnum()){
                isFindmax = true;
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<k+1; i++){
                    sb.append(nums[i]);
                }
                maxans = sb.toString();
            }
            return;
        }

        for(int i=9; i>=0; i--){
            if(!isSelected[i]){
                isSelected[i] = true;
                nums[idx]=i;
                findmaxans(idx+1);
                isSelected[i] = false;
            }
        }
    }
    static boolean isGoodnum(){
        for(int i=0; i<k; i++){
            if(opes[i]=='<'){
                if(nums[i+1] > nums[i]) continue;
                return false;
            }else{
                if(nums[i+1] < nums[i]) continue;
                return false;
            }
        }
        return true;
    }
}
