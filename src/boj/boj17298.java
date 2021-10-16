package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        ans[n-1]=-1;

        for(int i=n-2; i>=0; i--){
            int idx = i+1;

            while(idx!=-1 && num[idx]<=num[i]){
                idx = ans[idx];
            }
            ans[i]=idx;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(ans[i]==-1) sb.append(-1).append(' ');
            else sb.append(num[ans[i]]).append(' ');
        }
        System.out.println(sb);
    }
}
