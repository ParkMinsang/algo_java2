package boj;

import java.io.*;
import java.util.*;

public class boj12100 {
    static int n, ans;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        func(0,-1,board);
        System.out.println(ans);
    }
    static void func(int cnt, int d, int[][] b){
        if(cnt==5){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    ans = Math.max(ans, b[i][j]);
                }
            }
            return;
        }
        if(d==-1){
            for(int i=0; i<4; i++){
                func(cnt, i, b);
            }
            return;
        }

        int[][] tmp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tmp[i][j] = b[i][j];
            }
        }

        if(d==0){
            for(int c=0; c<n; c++){
                Stack<Integer> stack = new Stack<>();
                for(int r=0; r<n; r++){
                    if(tmp[r][c]==0) continue;
                    if(stack.isEmpty()){
                        stack.push(tmp[r][c]);
                    }else{
                        if(stack.peek()==tmp[r][c]){
                            stack.push(-2*stack.pop());
                        }else{
                            stack.push(tmp[r][c]);
                        }
                    }
                }
                int start = stack.size()-1;
                for(int i=start+1; i<n; i++) tmp[i][c]=0;
                while(!stack.isEmpty()){
                    tmp[start--][c] = Math.abs(stack.pop());
                }
            }
        }else if(d==1){
            for(int c=0; c<n; c++){
                Stack<Integer> stack = new Stack<>();
                for(int r=n-1; r>=0; r--){
                    if(tmp[r][c]==0) continue;
                    if(stack.isEmpty()){
                        stack.push(tmp[r][c]);
                    }else{
                        if(stack.peek()==tmp[r][c]){
                            stack.push(-2*stack.pop());
                        }else{
                            stack.push(tmp[r][c]);
                        }
                    }
                }
                int start = n-stack.size();
                for(int i=0; i<start; i++) tmp[i][c]=0;
                while(!stack.isEmpty()){
                    tmp[start++][c] = Math.abs(stack.pop());
                }
            }
        }else if(d==2){
            for(int r=0; r<n; r++){
                Stack<Integer> stack = new Stack<>();
                for(int c=0; c<n; c++){
                    if(tmp[r][c]==0) continue;
                    if(stack.isEmpty()){
                        stack.push(tmp[r][c]);
                    }else{
                        if(stack.peek()==tmp[r][c]){
                            stack.push(-2*stack.pop());
                        }else{
                            stack.push(tmp[r][c]);
                        }
                    }
                }
                int start = stack.size()-1;
                for(int i=start+1; i<n; i++) tmp[r][i]=0;
                while(!stack.isEmpty()){
                    tmp[r][start--] = Math.abs(stack.pop());
                }
            }
        }else if(d==3){
            for(int r=0; r<n; r++){
                Stack<Integer> stack = new Stack<>();
                for(int c=n-1; c>=0; c--){
                    if(tmp[r][c]==0) continue;
                    if(stack.isEmpty()){
                        stack.push(tmp[r][c]);
                    }else{
                        if(stack.peek()==tmp[r][c]){
                            stack.push(-2*stack.pop());
                        }else{
                            stack.push(tmp[r][c]);
                        }
                    }
                }
                int start = n-stack.size();
                for(int i=0; i<start; i++) tmp[r][i]=0;
                while(!stack.isEmpty()){
                    tmp[r][start++] = Math.abs(stack.pop());
                }
            }
        }

        for(int i=0; i<4; i++){
            func(cnt+1, i, tmp);
        }
    }
}
