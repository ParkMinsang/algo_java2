package boj;

import java.io.*;
import java.util.*;

public class boj15654 {
    static int n,m;
    static int[] nums;
    static int[] ans;
    static boolean[] isSelected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        isSelected = new boolean[n];
        ans = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int cnt){
        if(cnt==m){
            for(int i=0; i<m; i++){
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            if(isSelected[i]) continue;
            isSelected[i]=true;
            ans[cnt]=nums[i];
            permutation(cnt+1);
            isSelected[i]=false;
        }
    }

}
