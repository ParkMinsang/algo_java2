package boj;

import java.io.*;
import java.util.*;

public class boj2993 {
    static String s;
    static boolean[][][] memo;
    static PriorityQueue<String> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        pq = new PriorityQueue<>();
        memo = new boolean[s.length()][s.length()][s.length()];

        func(1,1,1);
        System.out.println(pq.poll());
    }
    static void func(int l1, int l2, int l3){
        if(memo[l1][l2][l3]) return;
        if(l1+l2+l3==s.length()){
            makeSentence(l1,l2,l3);
            return;
        }
        memo[l1][l2][l3]=true;

        func(l1+1, l2, l3);
        func(l1,l2+1, l3);
        func(l1,l2,l3+1);
    }

    static void makeSentence(int l1, int l2, int l3){
        int is=0, ie=l1-1;
        char[] ns = new char[s.length()];

        while(is<=ie){
            char tmp = s.charAt(is);
            ns[is]=s.charAt(ie);
            ns[ie]=tmp;
            is++; ie--;
        }

        is=l1; ie=l1+l2-1;
        while(is<=ie){
            char tmp = s.charAt(is);
            ns[is]=s.charAt(ie);
            ns[ie]=tmp;
            is++; ie--;
        }

        is=l1+l2; ie=l1+l2+l3-1;
        while(is<=ie){
            char tmp = s.charAt(is);
            ns[is]=s.charAt(ie);
            ns[ie]=tmp;
            is++; ie--;
        }
        pq.add(new String(ns));
    }
}
