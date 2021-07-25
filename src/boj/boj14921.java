package boj;

import java.io.*;
import java.util.*;

public class boj14921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] vals = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) vals[i] = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;

        //풀이 1
        int lt=0, rt=n-1, tmp=0;
        while(lt<rt){
            tmp = vals[lt]+vals[rt];

            ans = Math.abs(tmp)<Math.abs(ans)?tmp:ans;

            if(tmp>=0) rt--;
            else lt++;
        }

        //풀이 2
//        for(int i=0; i<n; i++){
//            int curr = vals[i];
//            int lt=i+1, rt=n-1, mt=0, tmp=0;
//
//            while(lt<=rt){
//                mt=(lt+rt)/2;
//                tmp = curr+vals[mt];
//
//                ans = Math.abs(tmp)<Math.abs(ans)?tmp:ans;
//
//                if(tmp>=0){
//                    rt=mt-1;
//                }else{
//                    lt=mt+1;
//                }
//            }
//        }
        System.out.println(ans);
    }
}
