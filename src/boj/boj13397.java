package boj;

import java.io.*;
import java.util.*;

public class boj13397 {
    static int n,m;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        int lt=0, rt=10000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;
            if(isPos(mt)){
                ans = mt;
                rt=mt-1;
            }else{
                lt=mt+1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPos(int mt){
        int cnt=1;
        int minVal=10001, maxVal=-1;
        for(int i=0; i<n; i++){
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);

            if (maxVal - minVal > mt){
                cnt++;
                minVal = nums[i];
                maxVal = nums[i];
            }
        }
        if(cnt>m) return false;
        return true;
    }
}
