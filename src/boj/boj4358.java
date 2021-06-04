package boj;

import java.io.*;
import java.util.*;

public class boj4358 {
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
        List<Tree> trees = new ArrayList<>();
        int idx=0;
        for(String key : treemap.keySet()){
            trees.add(new Tree(key, (double)treemap.get(key)*100/cnt));
        }

        Collections.sort(trees);

        for(Tree tree : trees){
            String ratio = String.format("%.4f", tree.per);
            System.out.println(tree.name +" " + ratio);
        }
    }

    public static class Tree implements Comparable<Tree>{
        double per;
        String name;
        Tree(String name, double per){
            super();
            this.name=name;
            this.per=per;
        }

        @Override
        public int compareTo(Tree o) {
            return this.name.compareTo(o.name);
        }
    }

}
