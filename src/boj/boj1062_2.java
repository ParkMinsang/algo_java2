package boj;

import java.io.*;
import java.util.*;

public class boj1062_2 {
    static int n,k,ans;
    static int isLearn=532741;
    static ArrayList<Integer> words;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new ArrayList<>();
        for(int i=0; i<n; i++){
            int word=532741;
            String input = br.readLine();
            for(int c=4; c<input.length()-4; c++){
                word |= 1<<(input.charAt(c)-'a');
            }
            words.add(word);
        }

        if(k<5){
            System.out.println(0);
            System.exit(0);
        }

        combination(0, 0);

        System.out.println(ans);
    }
    public static void combination(int cnt, int start){
        if(cnt==k-5){
            countReadableWord();
            return;
        }

        for(int i=start; i<26; i++){
            if((isLearn & (1<<i)) == 0){
                isLearn |= (1<<i);
                combination(cnt+1, i+1);
                isLearn ^= (1<<i);
            }
        }
    }

    public static void countReadableWord(){
        int currans=0;
        for(int word : words){
            if((word & isLearn) == word){
                currans++;
            }
        }
        ans = Math.max(ans, currans);
    }
}
