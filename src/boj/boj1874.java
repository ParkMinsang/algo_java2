package boj;

import java.io.*;
import java.util.*;

public class boj1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int curr=0;

        StringBuilder sb = new StringBuilder();
        boolean flag=true;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            while(curr<num){
                stack.add(++curr);
                sb.append("+\n");
            }

            if(!stack.isEmpty() && stack.peek()==num){
                stack.pop();
                sb.append("-\n");
            }else{
                flag = false;
            }
        }

        if(flag){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }

    }
}
