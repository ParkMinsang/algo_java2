package boj;

import java.io.*;
import java.util.*;

public class boj13460 {
    //4 direction search
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    static int[][] map;
    //memorization
    static boolean[][][][] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map size
        int n=0, m=0;
        // ball, hole position
        int redR=0, redC=0, blueR=0, blueC=0, holeR=0, holeC=0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][n][m];

        //input
        for(int i=0; i<n; i++){
            String line = br.readLine();

            for(int j=0; j<m; j++){
                char c = line.charAt(j);

                if(c=='#'){
                    map[i][j]=1;
                }else{
                    map[i][j]=0;
                }

                if(c=='O'){
                    holeR=i;
                    holeC=j;
                }else if(c=='R'){
                    redR=i;
                    redC=j;
                } else if (c == 'B') {
                    blueR=i;
                    blueC=j;
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(redR, redC, blueR, blueC));
        // ans, qsize
        int time=0, size=0;
        // ans check
        boolean flag=false;
        while(!q.isEmpty()){
            if(++time>10) break;
            size = q.size();

            for(int s=0; s<size; s++){
                Point curr = q.poll();
                visit[curr.rr][curr.rc][curr.br][curr.bc]=true;

                int nrr=0, nrc=0, nbr=0, nbc=0;

                for(int d=0; d<4; d++){
                    nrr = curr.rr;
                    nrc = curr.rc;
                    nbr = curr.br;
                    nbc = curr.bc;

                    while(true){
                        int brr = nrr, brc=nrc, bbr=nbr, bbc=nbc;
                        nrr+=dr[d];
                        nrc+=dc[d];
                        nbr+=dr[d];
                        nbc+=dc[d];

                        if(map[nrr][nrc]==1){
                            nrr-=dr[d];
                            nrc-=dc[d];

                            if(nbr==nrr && nbc==nrc){
                                nbr-=dr[d];
                                nbc-=dc[d];
                            }
                        }
                        if(map[nbr][nbc]==1){
                            nbr-=dr[d];
                            nbc-=dc[d];

                            if(nrr==nbr && nrc==nbc){
                                nrr-=dr[d];
                                nrc-=dc[d];
                            }
                        }
                        // fail
                        if(nbr==holeR && nbc==holeC) break;
                        // find ans
                        if(nrr==holeR && nrc==holeC){
                            if(isSameLine(nrr, nrc, nbr, nbc, d)){
                                nbr=holeR;
                                nbc=holeC;
                                break;
                            }else{
                                flag=true;
                                break;
                            }
                        }

                        //balls don't move
                        if(nrr==brr && nrc==brc && nbr==bbr && nbc==bbc) break;
                    }
                    if(flag) break;
                    if(visit[nrr][nrc][nbr][nbc] || (nbr==holeR && nbc==holeC)) continue;
                    visit[nrr][nrc][nbr][nbc] = true;
                    q.add(new Point(nrr,nrc,nbr,nbc));
                }
            }
            if(flag) break;
        }

        System.out.println(flag?time:-1);
    }

    static boolean isSameLine(int rr, int rc, int br, int bc, int d){
        // up, left, down, right
        if(d==0){
            if(rc != bc || br < rr) return false;
            else{
                for(int r = rr; r < br; r++){
                    if(map[r][rc]==1) return false;
                }
                return true;
            }
        }
        else if(d==1){
            if(rr != br || bc < rc) return false;
            else{
                for(int c = rc; c < bc; c++){
                    if(map[rr][c]==1) return false;
                }
                return true;
            }
        }
        else if(d==2){
            if(rc != bc || rr < br) return false;
            else{
                for(int r = br; r < rr; r++){
                    if(map[r][rc]==1) return false;
                }
                return true;
            }
        }
        else{
            if(rr != br || rc < bc) return false;
            else{
                for(int c = bc; c < rc; c++){
                    if(map[rr][c]==1) return false;
                }
                return true;
            }
        }
    }

    static class Point{
        int rr,rc,br,bc;
        Point(int rr, int rc, int br, int bc){
            this.rr=rr;
            this.rc=rc;
            this.br=br;
            this.bc=bc;
        }
    }
}
