package boj;

import java.io.*;
import java.util.*;

public class boj2977 {
    static int n,m, need;
    static int[][] recipe;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        recipe = new int[n][6];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<6; j++){
                recipe[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lt=0, rt=99000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;

            if(isPos(mt)){
                ans = mt;
                lt=mt+1;
            }else{
                rt=mt-1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPos(int mt){
        int spend=0;

        for(int i=0; i<n; i++){
            need = mt*recipe[i][0]-recipe[i][1];
            int currspend = minspent(i, need);
            spend += currspend;

            if(spend>m) return false;
        }
        return true;
    }

    static int minspent(int idx, int need){
        int ans=Integer.MAX_VALUE;
        int bigmax = need/recipe[idx][4] + (need%recipe[idx][4]==0?0:1);

        for(int j=bigmax; j>=0; j--){
            int tmp = need - j*recipe[idx][4];

            if(tmp<=0){
                ans = Math.min(ans, j*recipe[idx][5]);
                continue;
            }

            int sn = tmp/recipe[idx][2] + (tmp%recipe[idx][2]==0?0:1);
            ans = Math.min(ans, j*recipe[idx][5] + sn*recipe[idx][3]);
        }

        return ans;
    }
}
