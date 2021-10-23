package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cards = new int[n][m];
        int[] count = new int[n];
        int maxcnt=0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<m; j++){
                cards[i][j] = Integer.parseInt(st.nextToken());

                if(cards[i][j]>0) {
                    count[i]++;
                    maxcnt = Math.max(maxcnt, count[i]);
                }
            }
        }

        ArrayList<Integer> maxArr = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(count[i]==maxcnt) maxArr.add(i);
        }

        int ans = Integer.MAX_VALUE;
        for(int joker : maxArr){
            int currans=0;
            boolean[] isSelected = new boolean[m];

            for(int i=0; i<n; i++){
                if(i==joker) continue;
                if(count[i]>1){
                    currans++;
                }
                else if(count[i]==1){
                    int select = find(cards[i]);

                    if(isSelected[select]){
                        currans++;
                    }
                    else{
                        isSelected[select]=true;
                    }
                }
            }
            ans = Math.min(ans, currans);
        }
        System.out.println(ans);
    }

    static int find(int[] box){
        for(int i=0; i<box.length; i++){
            if(box[i]==1) return i;
        }
        return -1;
    }

}
