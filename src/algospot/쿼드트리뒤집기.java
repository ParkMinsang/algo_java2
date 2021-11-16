package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리뒤집기 {
    static int pointer;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            pointer=-1;
            str = br.readLine();
            sb.append(reverse()).append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static String reverse(){
        pointer++;
        char c = str.charAt(pointer);
        if(c!='x') return Character.toString(c);

        String u1 = reverse();
        String u2 = reverse();
        String d1 = reverse();
        String d2 = reverse();

        return "x"+d1+d2+u1+u2;
    }
}
