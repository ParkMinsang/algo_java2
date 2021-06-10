package boj;

import java.io.*;
import java.util.*;

public class boj1072 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = (y*100)/x;
        long tmp = 0;
        int lt=1, rt=1000000000, ans=-1, mt=0;
        while(lt<=rt){
            mt = (lt+rt)/2;
            tmp = ((y+mt)*100)/(x+mt);
            if(tmp == z){
                lt=mt+1;
            }else{
                rt=mt-1;
                ans=mt;
            }
        }
        System.out.println(ans);
    }
}
