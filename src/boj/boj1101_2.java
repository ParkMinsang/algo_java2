package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1101_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] isSelected = new boolean[m];

        int ans = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int cnt=0;
            int idx=0;
            for(int j=0; j<m; j++){
                int k = Integer.parseInt(st.nextToken());

                if(k>0){
                    cnt++;
                    idx=j;
                }
                if(cnt>1) break;
            }

            if(cnt>1) ans++;
            else if(cnt==1){
                if(isSelected[idx]) ans++;
                else isSelected[idx]=true;
            }
        }
        System.out.println(ans==0?0:ans-1);
    }
}
