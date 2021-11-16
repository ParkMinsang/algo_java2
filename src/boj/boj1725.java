package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1725 {
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        h = new int[n];
        for(int i=0; i<n; i++) h[i] = Integer.parseInt(br.readLine());

        System.out.println(getS(0, n-1));
    }

    static long getS(int left, int right){
        if(left==right) return h[left];
        long ret=0;
        int mid = (left+right)/2;
        ret = Math.max(getS(left, mid), getS(mid+1, right));

        int lo=mid, hi=mid+1;
        long height = Math.min(h[lo], h[hi]);
        ret = Math.max(ret, 2*height);

        while(left<lo || hi<right){
            if(hi<right && (lo==left || h[lo-1]<h[hi+1])){
                height = Math.min(height, h[++hi]);
            }else{
                height = Math.min(height, h[--lo]);
            }
            ret = Math.max(ret, (hi-lo+1)*height);
        }
        return ret;
    }
}

