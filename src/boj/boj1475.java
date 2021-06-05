package boj;

import java.io.*;

public class boj1475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[10];

        if(n==0){
            System.out.println(1);
        }else{
            while(n>0){
                nums[n%10]++;
                n/=10;
            }
            int ans=0;
            for(int i=0; i<10; i++){
                if(i==6 || i==9) continue;
                ans = Math.max(ans, nums[i]);
            }
            int tmp = (nums[6]+nums[9])/2 + (nums[6]+nums[9])%2;
            ans = Math.max(ans, tmp);
            System.out.println(ans);
        }



    }
}
