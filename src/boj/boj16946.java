package boj;

import java.io.*;
import java.util.*;

public class boj16946 {
    static ArrayList<Integer> arr;
    static boolean[][] isVisited;
    static int[][] map, ans, tmp;
    static int n,m;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = new int[n][m];
        tmp = new int[n][m];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                char c = line.charAt(j);
                map[i][j]=c-'0';
            }
        }

        arr = new ArrayList<>();
        isVisited = new boolean[n][m];
        int val=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0 && !isVisited[i][j]){
                    arr.add(0);
                    func(i, j, ++val);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    ans[i][j]=getAns(i,j);
                }else{
                    ans[i][j]=0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(ans[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static int getAns(int r, int c){
        int ret=1;
        Set<Integer> set = new HashSet<>();
        for(int d=0; d<4; d++){
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr<0 || nr>=n || nc<0 || nc>=m || map[nr][nc]!=0) continue;
            set.add(tmp[nr][nc]);
        }

        for(int val : set){
            ret += arr.get(val);
        }
        return ret%10;
    }

    static void func(int r, int c, int val){
        isVisited[r][c]=true;
        tmp[r][c]=val;
        arr.set(val, arr.get(val)+1);

        for(int d=0; d<4; d++){
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(nr<0 || nr>=n || nc<0 || nc>=m || map[nr][nc]!=0 || isVisited[nr][nc]) continue;
            func(nr, nc, val);
        }
    }
}