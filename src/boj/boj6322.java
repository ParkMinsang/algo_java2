package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int cycle=0;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if((a|b)==0 && (b|c)==0) break;
            cycle++;
            sb.append("Triangle #").append(cycle).append('\n');

            if(a==-1){
                if(b>=c){
                    sb.append("Impossible.").append('\n').append('\n');
                }else{
                    double ans = Math.round(Math.sqrt(c*c-b*b)*1000)/1000.0;
                    sb.append("a = ").append(String.format("%.3f", ans)).append('\n').append('\n');
                }
            }
            else if(b==-1){
                if(a>=c){
                    sb.append("Impossible.").append('\n').append('\n');
                }else{
                    double ans = Math.round(Math.sqrt(c*c-a*a)*1000)/1000.0;
                    sb.append("b = ").append(String.format("%.3f", ans)).append('\n').append('\n');
                }
            }
            else if(c==-1){
                double ans = Math.round(Math.sqrt(a*a+b*b)*1000)/1000.0;
                sb.append("c = ").append(String.format("%.3f", ans)).append('\n').append('\n');
            }
        }
        System.out.println(sb);
    }
}
