package boj;

import java.io.*;
import java.util.*;

public class boj10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int[] ans = new int[10001];
        int ss1 = s1.length()-1;
        int ss2 = s2.length()-1;

        int tmp=0;
        int idx=0;
        while(ss1>=0 || ss2>=0){
            int n1=0, n2=0;
            if(ss1>=0) n1=s1.charAt(ss1)-'0';
            if(ss2>=0) n2=s2.charAt(ss2)-'0';

            ans[idx]=(n1+n2+tmp)%10;
            tmp = (n1+n2+tmp)/10;

            ss1--;
            ss2--;
            idx++;
        }
        if(tmp>0) ans[idx]=tmp;
        else idx--;

        StringBuilder sb = new StringBuilder();
        for(int i=idx; i>=0; i--){
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }
}
