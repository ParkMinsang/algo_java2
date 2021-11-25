package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] cnt = new int[m];
        int ans = 0;
        for(int i=2; i<m; i++){
            if(s.charAt(i)=='O') continue;
            if(s.charAt(i-2)=='I' && s.charAt(i-1)=='O') cnt[i]=cnt[i-2]+1;
            if(cnt[i]>=n) ans++;
        }

        System.out.println(ans);
    }
}
