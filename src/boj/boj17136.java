package boj;

import java.io.*;
import java.util.*;

public class boj17136 {
    static int ans;
    static int[] papers;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        map = new int[10][10];
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = -1;
        papers = new int[6];
        for(int i=1; i<6; i++) papers[i]=5;
        dfs(0,0,0);
        System.out.println(ans);
    }
    static void dfs(int r, int c, int cnt){
        if(!hasOne()){
            if(ans==-1) ans=cnt;
            else ans=Math.min(ans, cnt);
            return;
        }
        if(ans!=-1 && cnt>=ans) return;

        if(r>=10) return;
        if(c>=10){
            dfs(r+1,0,cnt);
            return;
        }

        if(map[r][c]==1){
            for(int range=1; range<=5; range++){
                if(papers[range]>0 && isPos(r,c,range)){
                    papers[range]--;
                    charge(r,c,range,0);
                    dfs(r, c+range, cnt+1);
                    papers[range]++;
                    charge(r,c,range,1);
                }
            }
        }else{
            dfs(r,c+1,cnt);
        }
    }
    static boolean isPos(int r, int c, int range){
        for(int i=r; i<r+range; i++){
            for(int j=c; j<c+range; j++){
                if(i>=10 || j>=10 || map[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void charge(int r, int c, int range, int val){
        for(int i=r; i<r+range; i++){
            for(int j=c; j<c+range; j++){
                map[i][j] = val;
            }
        }
    }

    static boolean hasOne(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(map[i][j] == 1) return true;
            }
        }
        return false;
    }
}

