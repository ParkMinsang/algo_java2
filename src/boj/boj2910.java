package boj;

import java.io.*;
import java.util.*;

public class boj2910 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i]=num;

            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++){
            nodes[i] = new Node(nums[i], map.get(nums[i]));
        }
        Arrays.sort(nodes);

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            if(set.contains(nodes[i].num)) continue;
            set.add(nodes[i].num);
            for(int j=0; j<nodes[i].count; j++){
                sb.append(nodes[i].num).append(' ');
            }
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int num, count;
        Node(int num, int count){
            this.num=num;
            this.count=count;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(o.count, this.count);
        }
    }
}
