package boj;

import java.io.*;
import java.util.*;

public class boj14500 {
    static int n,m, ans;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][] board;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                isVisited[i][j]=true;
                dfs(i,j,1,board[i][j]);
                isVisited[i][j]=false;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int r, int c, int cnt, int sum){
        if(cnt==4){
            ans = Math.max(ans, sum);
            return;
        }

        int nr=0, nc=0;
        for(int d=0; d<4; d++){
            nr = r+dr[d];
            nc = c+dc[d];
            if(nr<0 || nr>=n || nc<0 || nc>=m || isVisited[nr][nc]) continue;
            isVisited[nr][nc]=true;
            dfs(nr,nc,cnt+1,sum+board[nr][nc]);
            dfs(r,c,cnt+1,sum+board[nr][nc]);
            isVisited[nr][nc]=false;
        }
    }
}
