package boj;

import java.io.*;
import java.util.*;

public class boj17255 {
    static String n;
    static int size;
    static Set<String> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        size = n.length();
        set = new HashSet<>();

        for(int i=0; i<n.length(); i++){
            dfs(i,i,""+n.charAt(i),""+n.charAt(i));
        }
        System.out.println(set.size());
    }

    static void dfs(int s, int e, String num, String path){
        if(s==0 && e==size-1){
            if(!set.contains(path)){
                set.add(path);
            }
            return;
        }

        if(s>0){
            StringBuilder newnum = new StringBuilder(num);
            newnum.insert(0, n.charAt(s-1));
            StringBuilder newpath = new StringBuilder(path);
            newpath.append(newnum);
            dfs(s-1, e, newnum.toString(), newpath.toString());
        }

        if(e<size-1){
            StringBuilder newnum = new StringBuilder(num);
            newnum.append(n.charAt(e+1));
            StringBuilder newpath = new StringBuilder(path);
            newpath.append(newnum);
            dfs(s, e+1, newnum.toString(), newpath.toString());
        }
    }


}
