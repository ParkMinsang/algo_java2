package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 울타리잘라내기 {
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        for(int tc=0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            h = new int[n];
            for(int i=0; i<n; i++) h[i] = Integer.parseInt(st.nextToken());
            sb.append(getS(0, n-1)).append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static int getS(int left, int right){
        if(left==right) return h[left];
        int ret=0;
        int mid = (left+right)/2;
        ret = Math.max(getS(left, mid), getS(mid+1, right));

        int lo=mid, hi=mid+1;
        int height = Math.min(h[lo], h[hi]);
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
