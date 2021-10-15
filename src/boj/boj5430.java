package boj;

import java.io.*;
import java.util.*;

public class boj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tt=0; tt<t; tt++){
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String initArr = br.readLine();
            List<Integer> arr = new LinkedList<>();

            int tmp=0;
            for(char c : initArr.toCharArray()){
                if(c>='0' && c<='9'){
                    tmp*=10;
                    tmp+=c-'0';
                }
                else{
                    if(tmp>0){
                        arr.add(tmp);
                        tmp=0;
                    }
                }
            }

            boolean hasError=false;
            boolean isReversed=false;
            for(char c : cmd.toCharArray()){
                if(c=='R') isReversed=!isReversed;
                else{
                    if(arr.size()>0) {
                        if(!isReversed){
                            arr.remove(0);
                        }else{
                            arr.remove(arr.size()-1);
                        }
                    }
                    else{
                        hasError=true;
                        break;
                    }
                }
            }

            if(hasError){
                sb.append("error").append('\n');
            }else{
                if(isReversed) Collections.reverse(arr);

                sb.append('[');
                for(int item : arr){
                    sb.append(item).append(',');
                }
                if(arr.size()>0) sb.setLength(sb.length()-1);
                sb.append(']').append('\n');
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
