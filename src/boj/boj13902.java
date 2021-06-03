package boj;

import java.io.*;
import java.util.*;

public class boj13902 {
    static final int INF = 999999;
    static int n,m;
    static int[] dp;
    static Integer[] dogu;
    static Set<Integer> woaks;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        int[] woak = new int[m];
        woaks = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<m; i++){
            woak[i] = Integer.parseInt(st.nextToken());
            woaks.add(woak[i]);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(i==j) continue;
                woaks.add(woak[i]+woak[j]);
            }
        }

        dogu = new Integer[woaks.size()];
        int i=0;
        for(int k : woaks){
            dogu[i] = k;
            i++;
        }
        Arrays.sort(dogu, Collections.reverseOrder());

        int ans = func(n);
        System.out.println(ans==INF?-1:ans);
    }
    static int func(int dishes){
        if(dishes==0) return 0;
        else if(dishes<0) return INF;

        if(dp[dishes] != 0) return dp[dishes];

        int result = INF;
        for(int k : dogu){
            result = Math.min(result, func(dishes-k)+1);
        }

        dp[dishes] = result;
        return dp[dishes];
    }
}
