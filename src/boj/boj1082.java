package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1082 {
    static int n, m, cnt;
    static int[] costs;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) costs[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        dp = new int[m+1][2];
        for(int i=0; i<m+1; i++) Arrays.fill(dp[i], -1);

        cnt = func(m, 0);

        StringBuilder sb = new StringBuilder();
        int ans = m, prev = 1;

        while(ans>0){
            boolean isAbstacted = false;
            for(int i=n-1; i>=0; i--){
                if(ans<costs[i] || (prev==0 && i==0)) continue;
                if(func(ans-costs[i], prev)==cnt-1){
                    isAbstacted = true;
                    ans-=costs[i];
                    cnt-=1;
                    sb.append(i);
                    break;
                }
            }
            if(!isAbstacted) break;
        }
        System.out.println(sb.length()==0?0:sb);
    }


    static int func(int k, int prev){
        if(k==0) return 0;
        if(dp[k][prev]!=-1) return dp[k][prev];

        int ret = 0;
        for(int i=0; i<n; i++){
            if(k<costs[i] || (prev==0 && i==0) ) continue;
            ret = Math.max(ret, func(k-costs[i], 1)+1);
        }
        dp[k][prev] = ret;
        return dp[k][prev];
    }

}
