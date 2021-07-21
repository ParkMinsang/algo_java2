package boj;

import java.io.*;
import java.util.*;

public class boj11319 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s; i++){
            String[] sentences = br.readLine().split(" ");
            int cons=0, vowel=0;
            for(String sentence : sentences){
                for(int idx=0; idx<sentence.length(); idx++){
                    char c = sentence.charAt(idx);
                    if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'
                    || c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                        vowel++;
                    }else{
                        cons++;
                    }
                }
            }
            sb.append(cons).append(' ').append(vowel).append('\n');
        }
        System.out.println(sb);
    }
}
