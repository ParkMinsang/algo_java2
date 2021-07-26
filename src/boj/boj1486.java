package boj;

import java.io.*;
import java.util.*;

public class boj1486 {
    static final int INF = 1000001;
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] M = new int[n][m];
        int[][] updist = new int[n][m];
        int[][] downdist = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                char c = s.charAt(j);
                if(c>='a' && c<='z'){
                    M[i][j] = c-'a'+26;
                }else{
                    M[i][j] = c-'A';
                }
            }
        }
        for(int i=0; i<n; i++) {
            Arrays.fill(updist[i], INF);
            Arrays.fill(downdist[i], INF);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[n][m];

        int ans = M[0][0];
        pq.add(new Edge(0,0,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(isVisited[curr.r][curr.c]) continue;
            isVisited[curr.r][curr.c]=true;
            updist[curr.r][curr.c]=curr.d;

            for(int d=0; d<4; d++){
                int nr=curr.r+dr[d];
                int nc=curr.c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m || isVisited[nr][nc] || Math.abs(M[nr][nc]-M[curr.r][curr.c])>t) continue;
                int dist=M[nr][nc]-M[curr.r][curr.c];
                int nd=curr.d + (dist<=0?1:(dist*dist));
                if(nd > D) continue;
                pq.add(new Edge(nr,nc,nd));
            }
        }

        isVisited = new boolean[n][m];
        pq.add(new Edge(0,0,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(isVisited[curr.r][curr.c]) continue;
            isVisited[curr.r][curr.c]=true;
            downdist[curr.r][curr.c]=curr.d;

            for(int d=0; d<4; d++){
                int nr=curr.r+dr[d];
                int nc=curr.c+dc[d];

                if(nr<0 || nr>=n || nc<0 || nc>=m || isVisited[nr][nc] || Math.abs(M[nr][nc]-M[curr.r][curr.c])>t) continue;
                int dist=M[curr.r][curr.c]-M[nr][nc];
                int nd=curr.d + (dist<=0?1:(dist*dist));
                if(nd > D) continue;
                pq.add(new Edge(nr,nc,nd));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(updist[i][j]+downdist[i][j]<=D) ans = Math.max(ans,M[i][j]);
            }
        }
        System.out.println(ans);
    }

    static class Edge implements Comparable<Edge>{
        int r,c,d;
        Edge(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.d, o.d);
        }
    }
}
