package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6549 {
    static int n;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            if(n==0) break;
            heights = new int[n];

            for(int i=0; i<n; i++) heights[i] = Integer.parseInt(st.nextToken());
            sb.append(getS(0, n-1)).append('\n');
        }
        System.out.println(sb);
    }

    static long getS(int left, int right){
        if(left==right) return heights[left];
        long ret=0;
        int mid = (left+right)/2;
        ret = Math.max(getS(left, mid), getS(mid+1, right));

        int lo=mid, hi=mid+1;
        long height = Math.min(heights[lo], heights[hi]);
        ret = Math.max(ret, 2*height);

        while(left<lo || hi<right){
            if(hi<right && (lo==left || heights[lo-1]<heights[hi+1])){
                height = Math.min(height, heights[++hi]);
            }else{
                height = Math.min(height, heights[--lo]);
            }
            ret = Math.max(ret, (hi-lo+1)*height);
        }
        return ret;
    }
}
