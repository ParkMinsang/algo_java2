package algospot;

import java.io.*;
import java.util.*;

public class 고대어사전 {
    static boolean ans;
    static boolean[] isVisited;
    static StringBuilder sb, curr;
    static int[][] adj;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc=0; tc<TC; tc++){
            ans = true;
            isVisited = new boolean[26];
            curr = new StringBuilder();
            adj = new int[26][26];

            int n = Integer.parseInt(br.readLine());
            String[] words = new String[n];
            for(int i=0; i<n; i++) words[i]=br.readLine();

            for(int i=0; i<n-1; i++){
                String s1 = words[i];
                String s2 = words[i+1];

                int minl = Math.min(s1.length(), s2.length());

                for(int j=0; j<minl; j++){
                    if(s1.charAt(j) == s2.charAt(j)){
                        if(j==minl-1 && s1.length()>s2.length()){
                            ans = false;
                        }
                    }else{
                        adj[s1.charAt(j)-97][s2.charAt(j)-97]=1;
                        break;
                    }
                }
            }

            if(!ans){
                sb.append("INVALID HYPOTHESIS").append('\n');
                continue;
            }else{
                dfsAll();
            }

            curr = curr.reverse();

            for(int i=0; i<25; i++){
                for(int j=i+1; j<26; j++){
                    int a = curr.charAt(i)-97;
                    int b = curr.charAt(j)-97;

                    if(adj[b][a]==1) ans=false;
                }
            }

            if(!ans) sb.append("INVALID HYPOTHESIS").append('\n');
            else sb.append(curr).append('\n');

        }
        System.out.println(sb);
    }

    static void dfsAll(){
        for(int i=0; i<26; i++){
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }

    static void dfs(int here){
        isVisited[here]=true;

        for(int there=0; there<26; there++){
            if(!isVisited[there] && adj[here][there]==1){
                dfs(there);
            }
        }
        curr.append((char)(here+97));
    }
}
