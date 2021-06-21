package boj;

import java.io.*;
import java.util.*;

public class boj3197 {
    static int R,C;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][] map, currmap;
    static Point swan1, swan2;
    static boolean[][] isSwanVisited;
    static Queue<Point> SwanQ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        currmap = new int[R][C];

        String s= null;
        swan1=null; swan2=null;
        Queue<Point> q = new LinkedList<>();
        SwanQ = new LinkedList<>();
        for(int i=0; i<R; i++){
            s = br.readLine();
            for(int j=0; j<C; j++){
                char c = s.charAt(j);
                if(c=='L'){
                    q.add(new Point(i,j));
                    if(swan1==null){
                        swan1 = new Point(i,j);
                        map[i][j] = -1;
                        SwanQ.add(new Point(i,j));
                    }else{
                        swan2 = new Point(i,j);
                        map[i][j] = -2;
                    }
                }else if(c=='.'){
                    map[i][j] = 0;
                    q.add(new Point(i,j));
                }else{ // c=='X'
                    map[i][j] = -3;
                }
            }
        }
        isSwanVisited = new boolean[R][C];
        isSwanVisited[swan1.r][swan1.c]=true;

        int ans=0, size=0;
        boolean[][] isVisited = new boolean[R][C];
        isVisited[swan1.r][swan1.c] = true;
        isVisited[swan2.r][swan2.c] = true;

        while(!isConnected()){
            ans++;
            size = q.size();

            int nr=0, nc=0;
            for(int i=0; i<size; i++){
                Point curr = q.poll();

                for(int d=0; d<4; d++) {
                    nr = curr.r + dr[d];
                    nc = curr.c + dc[d];

                    if(nr<0 || nr>=R || nc<0 || nc>=C || isVisited[nr][nc]) continue;
                    isVisited[nr][nc]=true;
                    if(map[nr][nc]==-3){
                        map[nr][nc]=0;
                        q.add(new Point(nr,nc));
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static boolean isConnected(){
        Queue<Point> nextQ = new LinkedList<>();

        int nr=0, nc=0;
        while(!SwanQ.isEmpty()){
            Point curr = SwanQ.poll();
            for(int d=0; d<4; d++){
                nr = curr.r+dr[d];
                nc = curr.c+dc[d];

                if(nr<0 || nr>=R || nc<0 || nc>=C || isSwanVisited[nr][nc]) continue;

                if(map[nr][nc]==-2) return true;
                isSwanVisited[nr][nc]=true;
                if(map[nr][nc]==-3){
                    nextQ.add(new Point(nr,nc));
                }
                else if(map[nr][nc]==0){
                    SwanQ.add(new Point(nr,nc));
                }
            }
        }
        while(!nextQ.isEmpty()){
            SwanQ.add(nextQ.poll());
        }
        return false;
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
