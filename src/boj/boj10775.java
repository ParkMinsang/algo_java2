package boj;

import java.io.*;
import java.util.*;

public class boj10775 {
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parents = new int[g+1];
        for(int i=0; i<g+1; i++) parents[i]=i;
        int[] pi = new int[p];
        for(int i=0; i<p; i++){
            pi[i] = Integer.parseInt(br.readLine());
        }

        int ans=0;
        for(int k=0; k<p; k++){
            int park = findset(parents[pi[k]]);
            if(park==0) break;

            ans++;
            parents[park]=park-1;
        }
        System.out.println(ans);
    }
    static int findset(int a){
        if(parents[a]==a) return a;
        return parents[a]=findset(parents[a]);
    }
}
