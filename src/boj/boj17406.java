package boj;

import java.io.*;
import java.util.*;

public class boj17406 {
    static int n,m,k, ans;
    static boolean[] isSelected;
    static int[] permu;
    static int[][] board;
    static Operator[] opes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        opes = new Operator[k];
        isSelected = new boolean[k];
        permu = new int[k];

        board = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            int s=Integer.parseInt(st.nextToken());
            opes[i] = new Operator(r,c,s);
        }

        ans = Integer.MAX_VALUE;
        permutation(0);
        System.out.println(ans);
    }
    static void permutation(int idx){
        if(idx==k){
            int[][] currmap = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    currmap[i][j] = board[i][j];
                }
            }

            for(int i=0; i<k; i++){
                operate(currmap, opes[permu[i]]);
            }

            for(int i=0; i<n; i++){
                int currans = 0;
                for(int j=0; j<m; j++){
                    currans+=currmap[i][j];
                }
                ans=Math.min(ans, currans);
            }
            return;
        }

        for(int i=0; i<k; i++){
            if(!isSelected[i]){
                isSelected[i]=true;
                permu[idx] = i;
                permutation(idx+1);
                isSelected[i]=false;
            }
        }
    }

    static void operate(int[][] map, Operator ope){
        circle(map, new Point(ope.r-ope.s, ope.c-ope.s), new Point(ope.r+ope.s, ope.c+ope.s));
    }

    static void circle(int[][] map, Point h, Point l){
        if(h.r>=l.r || h.c>=l.c) return;

        int hr, ll, lr;
        hr = map[h.r][l.c];
        ll = map[l.r][h.c];
        lr = map[l.r][l.c];

        for(int i=l.c; i>h.c; i--) map[h.r][i] = map[h.r][i-1]; // 상
        for(int i=l.r; i>h.r; i--) map[i][l.c] = map[i-1][l.c]; // 우
        for(int i=h.c; i<l.c; i++) map[l.r][i] = map[l.r][i+1]; // 하
        for(int i=h.r; i<l.r; i++) map[i][h.c] = map[i+1][h.c]; // 좌

        map[h.r+1][l.c] = hr;
        map[l.r][l.c-1] = lr;
        map[l.r-1][h.c] = ll;

        circle(map, new Point(h.r+1, h.c+1), new Point(l.r-1, l.c-1));
    }

    static class Point{
        int r,c;
        Point(int r,int c){
            super();
            this.r=r;
            this.c=c;
        }
    }

    static class Operator{
        int r,c,s;
        Operator(int r, int c, int s){
            this.r=r;
            this.c=c;
            this.s=s;
        }
    }
}
