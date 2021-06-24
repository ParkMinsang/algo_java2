package boj;

import java.io.*;
import java.util.*;

public class boj2776 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<n; i++) nums[i]=Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(br.readLine());
            int[] checks = new int[m];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<m; i++) checks[i]=Integer.parseInt(st.nextToken());

            Arrays.sort(nums);
            for(int k=0; k<m; k++){
                boolean isFind = false;
                int lt=0, rt=n-1, mt=0;
                while(lt<=rt){
                    mt=(lt+rt)/2;
                    if(nums[mt]==checks[k]){
                        isFind=true;
                        break;
                    }
                    else if(nums[mt]>checks[k]){
                        rt=mt-1;
                    }
                    else{
                        lt=mt+1;
                    }
                }
                if(isFind){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
