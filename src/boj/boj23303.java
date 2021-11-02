package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj23303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if((c=='d' || c=='D') && i<s.length()-1 && s.charAt(i+1)=='2'){
                System.out.println("D2");
                System.exit(0);
            }
        }
        System.out.println("unrated");
    }
}
