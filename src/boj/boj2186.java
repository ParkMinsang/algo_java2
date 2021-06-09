package boj;

import java.io.*;
import java.util.*;

public class boj2186 {
    static int n,m,k;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][][] dp;
    static char[][] board;
    static String comment;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        String tmp=null;
        for(int i=0; i<n; i++){
            tmp = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        comment = br.readLine();
        dp = new int[n][m][comment.length()+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == comment.charAt(0)){
                    ans += func(i,j,1);
                }
            }
        }
        System.out.println(ans);
    }
    static int func(int r, int c, int idx){
        if(r<0 || r>=n || c<0 || c>=m) return 0;
        if(dp[r][c][idx] != -1) return dp[r][c][idx];
        if(idx==comment.length()) return 1;

        int ret=0;
        int nr=0, nc=0;
        for(int i=1; i<=k; i++){
            for(int d=0; d<4; d++){
                nr = r+dr[d]*i;
                nc = c+dc[d]*i;
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(board[nr][nc] == comment.charAt(idx)){
                    ret += func(nr, nc, idx+1);
                }
            }
        }
        dp[r][c][idx]=ret;
        return dp[r][c][idx];
    }
}
