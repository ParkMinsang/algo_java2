package boj;

import java.io.*;
import java.util.*;

public class boj15685 {
    static int ans;
    static boolean[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new boolean[101][101];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            String s = null;
            if(d==0) s="R";
            else if(d==1) s="U";
            else if(d==2) s="L";
            else s="D";

            drawline(r,c,func(s,g));
        }
        ans = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && isAns(i,j)) ans++;
            }
        }
        System.out.println(ans);
    }
    static boolean isAns(int r, int c){
        if(map[r+1][c] && map[r][c+1] && map[r+1][c+1]) return true;
        return false;
    }
    static void drawline(int r, int c, String command){
        map[r][c] = true;

        int nr=r, nc=c;

        for(int i=0; i<command.length(); i++){
            if(command.charAt(i)=='R'){
                nc++;
                map[nr][nc]=true;
            }
            else if(command.charAt(i)=='U'){
                nr--;
                map[nr][nc]=true;
            }
            else if(command.charAt(i)=='L'){
                nc--;
                map[nr][nc]=true;
            }
            else{
                nr++;
                map[nr][nc]=true;
            }
        }
    }

    static String func(String s, int g){
        if(g==0) return s;

        StringBuilder sb = new StringBuilder(s);
        sb.append(rev(s));

        return func(sb.toString(), g-1);
    }

    static String rev(String s){
        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='R') sb.append('U');
            else if(s.charAt(i)=='U') sb.append('L');
            else if(s.charAt(i)=='L') sb.append('D');
            else sb.append('R');
        }

        return sb.toString();
    }
}
