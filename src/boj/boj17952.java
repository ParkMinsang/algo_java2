package boj;

import java.io.*;
import java.util.*;

public class boj17952 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Todo> stack = new Stack<>();
        int ans=0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int type = Integer.parseInt(st.nextToken());

            if(type==1){
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if(T==1){
                    ans+=A;
                }else{
                    stack.add(new Todo(A, 1, T));
                }
            }else{
                if(!stack.isEmpty()){
                    Todo todo = stack.pop();
                    todo.curr++;
                    if(todo.curr==todo.comp){
                        ans+=todo.score;
                    }else{
                        stack.add(todo);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Todo{
        int score, curr, comp;
        Todo(int score, int curr, int comp){
            super();
            this.score=score;
            this.curr=curr;
            this.comp=comp;
        }
    }
}
