package boj;

import java.io.*;
import java.util.*;

public class boj1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int command = 0;
        for(int i=0; i<n; i++){
            command = Integer.parseInt(br.readLine());

            if(command!=0){
                pq.add(command);
            }else{
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
