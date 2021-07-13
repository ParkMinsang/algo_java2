package boj;

import java.io.*;
import java.util.*;

public class boj2661 {
    static int n;
    static int[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];

        func(0);
    }

    static void func(int idx){
        if(idx==n){
            StringBuilder sb = new StringBuilder();
            for(int i : ans){
                sb.append(i);
            }
            System.out.println(sb);
            System.exit(0);
        }

        for(int i=1; i<4; i++){
            ans[idx]=i;
            if(isPos(idx, i)){
                func(idx+1);
            }
        }
    }

    static boolean isPos(int idx, int i){
        for(int k=1; k<=(idx+1)/2; k++){
            int s=idx, e=idx-k;
            boolean isSame = false;
            for(int j=0; j<k; j++){
                if(ans[s-j] != ans[e-j]){
                    break;
                }
                if(j==k-1 && ans[s-j]==ans[e-j]){
                    isSame=true;
                }
            }
            if(isSame) return false;
        }
        return true;
    }
}
