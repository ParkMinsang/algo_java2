package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        Alpha[] alphas = new Alpha[26];
        for(int i=0; i<26; i++) alphas[i] = new Alpha(i);

        for(int i=0; i<n; i++){
            String s = br.readLine();
            strings[i] = s;

            for(int j=0; j<s.length(); j++){
                int idx = s.charAt(j)-'A';
                alphas[idx].idxs[s.length()-1-j]++;
            }
        }

        PriorityQueue<Alpha> pq = new PriorityQueue<>();
        for(int i=0; i<26; i++){
            pq.add(alphas[i]);
        }

        int[] vals = new int[26];

        int max=9;
        while(!pq.isEmpty() && max>0){
            Alpha alpha = pq.poll();
            vals[alpha.val] = max--;
        }

        int ans=0;
        for(String s : strings){
            int tmp=0;
            for(int i=0; i<s.length(); i++){
                tmp*=10;
                int idx = s.charAt(i)-'A';
                tmp+=vals[idx];
            }
            ans+=tmp;
        }
        System.out.println(ans);
    }

    static class Alpha implements Comparable<Alpha>{
        int val;
        int[] idxs;
        Alpha(int val){
            idxs=new int[8];
            this.val=val;
        }

        @Override
        public int compareTo(Alpha o) {
            StringBuilder sb = new StringBuilder();
            for(int i=7; i>=0; i--){
                sb.append(this.idxs[i]);
            }
            int me = Integer.parseInt(sb.toString());

            StringBuilder sb2 = new StringBuilder();
            for(int i=7; i>=0; i--){
                sb2.append(o.idxs[i]);
            }
            int other = Integer.parseInt(sb2.toString());

            return Integer.compare(other, me);
        }
    }
}
