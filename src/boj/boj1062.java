package boj;

import java.io.*;
import java.util.*;

public class boj1062 {
    static int n,k,ans;
    static boolean[] isLearn;
    static ArrayList<String> words;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        for(int i=0; i<n; i++){
            words.add(br.readLine());
        }

        if(k<5){
            System.out.println(0);
            System.exit(0);
        }
        isLearn = new boolean[26];
        isLearn[(int)'a'-'a']=true;
        isLearn[(int)'n'-'a']=true;
        isLearn[(int)'t'-'a']=true;
        isLearn[(int)'i'-'a']=true;
        isLearn[(int)'c'-'a']=true;

        combination(0, 0);

        System.out.println(ans);
    }
    public static void combination(int cnt, int start){
        if(cnt==k-5){
            countReadableWord();
            return;
        }

        for(int i=start; i<26; i++){
            if(!isLearn[i]){
                isLearn[i]=true;
                combination(cnt+1, i+1);
                isLearn[i]=false;
            }
        }
    }

    public static void countReadableWord(){
        int currans=0;
        for(String word : words){
            if(isReadable(word)) currans++;
        }
        ans = Math.max(ans, currans);
    }

    public static boolean isReadable(String word){
        for(int c=4; c<word.length()-4; c++){
            if(!isLearn[(int)word.charAt(c)-'a']) {
                return false;
            }
        }
        return true;
    }
}
