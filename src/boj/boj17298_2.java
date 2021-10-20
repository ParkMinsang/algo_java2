package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i]=Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){
            // 현재 확인할 숫자, 뒤에서부터 확인한다.
            int curr = nums[i];

            // 스택이 비어있지 않고, peek 값이 현재 값보다 작거나 같으면 pop한다.
            while(!stack.isEmpty() && stack.peek()<=curr){
                stack.pop();
            }

            // 스택이 비어있으면 현재 숫자가 가장 큰 것이다.
            if(stack.isEmpty()) ans[i]=-1;
            // 스택이 남아있으면 현재 숫자보다 큰 값이 peek 값이다.
            else ans[i]=stack.peek();

            // 스택에 현재 숫자를 넣는다.
            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
