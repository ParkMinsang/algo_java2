package boj;

import java.io.*;
import java.util.*;

public class boj3020 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] low = new int[h];
        int[] high = new int[h];

        for(int i=0; i<n; i++){
            int obstacle = Integer.parseInt(br.readLine());
            if(i%2==0){
                low[obstacle-1]++;
            }else{
                high[obstacle-1]++;
            }
        }

        for(int i=h-2; i>=0; i--){
            low[i] += low[i+1];
            high[i] += high[i+1];
        }

        int[] obstacles = new int[h];
        for(int i=0; i<h; i++){
            obstacles[i] = low[i]+high[h-1-i];
        }

        Arrays.sort(obstacles);

        Arrays.sort(obstacles);
        int min = obstacles[0];
        int lt=0, rt=h-1, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;
            if(obstacles[mt] > min){
                rt=mt-1;
            }else{
                lt=mt+1;
                ans = mt;
            }
        }
        System.out.println(min+" "+(ans+1));
    }
}
