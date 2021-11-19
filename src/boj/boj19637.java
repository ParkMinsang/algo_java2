package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] titles = new String[n];
        int[] maximum = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            titles[i] = st.nextToken();
            maximum[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int power = Integer.parseInt(br.readLine());

            int lt=0, rt=n-1, mt=0, idx=0;
            while(lt<=rt){
                mt = (lt+rt)/2;

                if(power<=maximum[mt]){
                    idx=mt;
                    rt=mt-1;
                }else{
                    lt=mt+1;
                }
            }
            sb.append(titles[idx]).append('\n');
        }

        System.out.println(sb);
    }
}
