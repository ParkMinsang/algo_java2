package boj;

import java.io.*;
import java.util.*;

public class boj1103 {
    static int n,m;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][] board;
    static int[][] dp;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board=new int[n][m];
        for(int i=0; i<n;i++){
            String inputline = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = inputline.charAt(j)-'0';
            }
        }

        dp=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        isVisited = new boolean[n][m];
        System.out.println(func(0,0));
    }
    static int func(int r, int c){
        if(r<0 || r>=n || c<0 || c>=m || board[r][c]==('H'-'0')) return 0;
        if((r!=0 || c!=0) && isVisited[r][c]){
            System.out.println(-1);
            System.exit(0);
        }
        if(dp[r][c] != -1) return dp[r][c];

        isVisited[r][c]=true;

        int ret=0;
        for(int d=0; d<4; d++){
            int nr=r+dr[d]*board[r][c];
            int nc=c+dc[d]*board[r][c];
//            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
            ret = Math.max(ret, 1+func(nr, nc));
        }
        dp[r][c] = ret;

        isVisited[r][c]=false;
        return dp[r][c];
    }
}
