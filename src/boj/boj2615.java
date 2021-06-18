package boj;

import java.io.*;
import java.util.*;

public class boj2615 {
    static int[] dr={0,1,1,-1}, dc={1,0,1,1};
    static int[][] map;
    static int[][][][] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[19][19];
        memo = new int[19][19][3][4];
        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                for(int d=0; d<4; d++){
                    if(dfs(i,j,map[i][j], d)==5){
                        boolean isSix=false;
                        for(int p=0; p<4; p++){
                            int nr=i+dr[p];
                            int nc=j+dc[p];
                            if(nr<0 || nr>=19 || nc<0 || nc>=19) continue;
                            if(dfs(nr,nc,map[nr][nc], d)==6) isSix=true;
                        }

                        if(isSix) continue;
                        System.out.println(map[i][j]);
                        System.out.println((i+1)+" "+(j+1));
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
    static int dfs(int r, int c, int type, int dir){
        if(r<0 || c<0 || r>=19 || c>=19 || type==0) return 0;
        if(map[r][c] != type) return 0;
        if(memo[r][c][type][dir] != 0) return memo[r][c][type][dir];

        int ret=0;
        ret = 1+dfs(r+dr[dir], c+dc[dir], type, dir);

        memo[r][c][type][dir]=ret;
        return memo[r][c][type][dir];
    }
}
