package boj;

import java.io.*;
import java.util.*;

public class boj2504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Integer> stack = new Stack<>();

        boolean isPos = true;
        int answer = 0;
        int ret=0;
        for(int i=0; i<line.length(); i++){
            char c = line.charAt(i);

            if(c=='('){
                stack.push(-1);
            }else if(c=='['){
                stack.push(-2);
            }else if(c==')'){
                if(stack.isEmpty()) {
                    isPos=false;
                    break;
                }
                ret=0;
                while(!stack.isEmpty()){
                    int prev = stack.pop();
                    if(prev == -2){
                        isPos = false;
                        break;
                    }
                    else if(prev == -1){
                        if(ret == 0) stack.push(2);
                        else stack.push(2*ret);
                        break;
                    }else{
                        ret += prev;
                    }
                }

            }else if(c==']'){
                if(stack.isEmpty()) {
                    isPos=false;
                    break;
                }
                ret=0;
                while(!stack.isEmpty()){
                    int prev = stack.pop();
                    if(prev == -1){
                        isPos = false;
                        break;
                    }
                    else if(prev == -2){
                        if(ret == 0) stack.push(3);
                        else stack.push(3*ret);
                        break;
                    }else{
                        ret += prev;
                    }
                }
            }
        }

        if(isPos){
            while(!stack.isEmpty()){
                int prev = stack.pop();
                if(prev == -1 || prev == -2){
                    answer = 0;
                    break;
                }
                answer += prev;
            }
            System.out.println(answer);
        }else{
            System.out.println(0);
        }

    }
}
