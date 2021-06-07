package boj;

import java.io.*;
import java.util.*;

public class boj11091 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = null;
        StringBuilder sb = null;
        int[] cnt = null;

        for(int i=0; i<n; i++){
            s = br.readLine();
            sb = new StringBuilder();
            cnt = new int[26];

            for(int c=0; c<s.length(); c++){
                if(s.charAt(c)>='a' && s.charAt(c)<='z'){
                    cnt[s.charAt(c)-'a']++;
                }
                else if(s.charAt(c)>='A' && s.charAt(c)<='Z'){
                    cnt[s.charAt(c)-'A']++;
                }
            }
            boolean isPangram=true;
            for(int c=0; c<26; c++){
                if(cnt[c]==0) {
                    isPangram=false;
                    sb.append((char)(c+'a'));
                }
            }

            if(isPangram){
                System.out.println("pangram");
            }else{
                System.out.println("missing "+sb.toString());
            }

        }

    }
}
