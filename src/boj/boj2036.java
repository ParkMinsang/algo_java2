package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] reversed = new int[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        for(int i=0; i<n; i++) reversed[i]=arr[n-1-i];

        long ans=0;

        int i=0;
        while(i<n && arr[i]<=0){
            int next = i+1;
            if(next>=n || arr[next]>0){
                ans += arr[i];
                i++;
            }else{
                ans += (long)arr[i]*arr[next];
                i+=2;
            }
        }

        i=0;
        while(i<n && reversed[i]>0){
            int next = i+1;

            if(next>=n || reversed[next]<=1){
                ans += reversed[i];
                i++;
            }else{
                ans += (long)reversed[i]*reversed[next];
                i+=2;
            }
        }
        System.out.println(ans);
    }
}
