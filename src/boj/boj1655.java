package boj;

import java.io.*;
import java.util.*;

public class boj1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(i%2==0){
                if(pq1.isEmpty()) pq1.add(num);
                else{
                    if(num > pq2.peek()){
                        pq1.add(pq2.poll());
                        pq2.add(num);
                    }else{
                        pq1.add(num);
                    }
                }
            }else{
                if(pq1.peek() > num){
                    pq2.add(pq1.poll());
                    pq1.add(num);
                }else{
                    pq2.add(num);
                }
            }

            sb.append(pq1.peek()).append("\n");
        }
        System.out.println(sb);

    }
}
