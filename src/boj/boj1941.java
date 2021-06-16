package boj;

import java.io.*;
import java.util.*;

public class boj1941 {
    static int ans;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];

        for(int i=0; i<5; i++){
            String line = br.readLine();
            for(int j=0; j<5; j++){
                map[i][j] = line.charAt(j);
            }
        }

        ans = 0;
        recur(0,0,0,0);
        System.out.println(ans);
    }
    public static void recur(int idx, int team, int cnt, int cnty){
        if(cnt > 7 || cnty>3) return;

        if(cnt==7){
            simulation(team);
            return;
        }
        if(idx==25) return;

        int isY = map[idx/5][idx%5]=='S'?0:1;

        recur(idx+1, team|(1<<idx), cnt+1, cnty+isY);
        recur(idx+1, team, cnt, cnty);
    }
    public static void simulation(int team){
        int[][] currmap = new int[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++) {
                if((team & (1<<(i*5+j))) != 0)
                    currmap[i][j]=1;
            }
        }

        if(!isConnected(currmap)) return;
        ans++;
    }

    public static boolean isConnected(int[][] map){
        boolean[][] isVisited = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j] == 1){
                    q.add(new Point(i,j));
                    break;
                }
            }
            if(q.size()>0) break;
        }
        int connect=0;
        while(!q.isEmpty()){
            Point curr = q.poll();
            connect++;
            isVisited[curr.r][curr.c]=true;

            for(int d=0; d<4; d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];

                if(nr<0 || nr>=5 || nc<0 || nc>=5 || isVisited[nr][nc]) continue;

                if(map[nr][nc]==1){
                    isVisited[nr][nc]=true;
                    q.add(new Point(nr,nc));
                }
            }

        }
        if(connect==7) return true;
        else return false;
    }

    static class Point{
        int r,c;
        Point(int r, int c){
            super();
            this.r=r;
            this.c=c;
        }
    }
}
