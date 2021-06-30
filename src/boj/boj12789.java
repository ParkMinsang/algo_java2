package boj;

import java.io.*;
import java.util.*;

public class boj12789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            line[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=n-1; i>=0; i--) stack.add(line[i]);

        int order = 1;

        while(!stack.isEmpty()){
            if(stack.peek()==order){
                stack.pop();
                order++;
            }else if(!stack2.isEmpty() && stack2.peek()==order){
                stack2.pop();
                order++;
            }else{
                if(stack2.isEmpty()){
                    stack2.add(stack.pop());
                }
                else{
                    if(stack2.peek()<stack.peek()){
                        System.out.println("Sad");
                        System.exit(0);
                    }else{
                        stack2.add(stack.pop());
                    }
                }
            }
        }
        System.out.println("Nice");
    }
}
