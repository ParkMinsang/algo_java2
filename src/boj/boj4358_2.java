package boj;

import java.io.*;
import java.util.*;

public class boj4358_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treemap = new HashMap<>();
        String input = null;
        int cnt=0;
        while(true){
            input = br.readLine();
            if(input == null || input.length()==0) break;

            if(treemap.containsKey(input)){
                treemap.put(input, treemap.get(input)+1);
            }else{
                treemap.put(input, 1);
            }
            cnt++;
        }

        String[] trees = new String[treemap.size()];
        int idx=0;
        for(String key : treemap.keySet()){
            trees[idx++] = key;
        }
        Arrays.sort(trees);

        StringBuilder sb = new StringBuilder();
        for(String tree : trees){
            sb.append(tree+" ").append(String.format("%.4f",(double)treemap.get(tree)*100/cnt)).append("\n");
        }
        System.out.println(sb);
    }
}
