package boj;

import java.io.*;
import java.util.*;

public class boj2568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a,b);
        }
        Arrays.sort(lines);

        int[] LIS = new int[n];
        int[] orders = new int[n];
        int size=0;

        for(int i=0; i<n; i++){
            int idx = Arrays.binarySearch(LIS,0,size,lines[i].b);
            idx = -idx-1;
            LIS[idx]=lines[i].b;
            orders[i]=idx;
            if(idx==size) size++;
        }

        System.out.println(n-size);

        for(int i=n-1; i>=0; i--){
            if(orders[i]==size-1){
                size--;
                orders[i]=1;
            }else{
                orders[i]=0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(orders[i]==0){
                sb.append(lines[i].a).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Line implements Comparable<Line>{
        int a,b;
        Line(int a, int b){
            super();
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.a, o.a);
        }
    }
}
