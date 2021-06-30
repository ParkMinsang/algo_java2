package boj;

import java.io.*;
import java.util.*;

public class boj6119 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Deque<Integer> dq = new ArrayDeque<>();
        int S = Integer.parseInt(br.readLine());
        int start=0;
        for(int i=0; i<S; i++){
            st = new StringTokenizer(br.readLine()," ");
            if(st.nextToken().equals("A")){
                start++;
                if(st.nextToken().equals("L")){
                    dq.addFirst(start);
                }else{
                    dq.addLast(start);
                }
            }
            else{
                String d = st.nextToken();
                int k = Integer.parseInt(st.nextToken());

                if(d.equals("L")){
                    for(int j=0; j<k; j++){
                        dq.pollFirst();
                    }
                }else{
                    for(int j=0; j<k; j++){
                        dq.pollLast();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst()).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
