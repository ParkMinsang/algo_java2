package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2104 {
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        val = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) val[i] = Integer.parseInt(st.nextToken());

        System.out.println(getMax(0, n-1));
    }

    static long getMax(int left, int right){
        if(left==right) return (long)val[left]*val[left];
        int mid = (left+right)/2;
        long ret = Math.max(getMax(left, mid), getMax(mid+1, right));

        int lo=mid, hi=mid+1;
        int minval = Math.min(val[lo], val[hi]);
        long sum = val[lo]+val[hi];
        ret = Math.max(ret, sum*minval);
        while(left<lo || hi<right){
            if(hi<right && (lo==left || val[lo-1]<val[hi+1])){
                ++hi;
                sum+=val[hi];
                minval = Math.min(minval, val[hi]);
            }else{
                --lo;
                sum+=val[lo];
                minval = Math.min(minval, val[lo]);
            }
            ret = Math.max(ret, sum*minval);
        }
        return ret;
    }
}
