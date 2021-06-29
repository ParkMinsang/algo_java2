package boj;

import java.io.*;
import java.util.*;

public class boj17143 {
    static int R,C;
    static int[] dr={0,-1,1,0,0}, dc={0,0,0,1,-1};
    static Shark[][] map;
    static PriorityQueue<Shark> pq, pq2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        pq = new PriorityQueue<>();
        pq2= new PriorityQueue<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r,c,s,d,z);
            pq.add(new Shark(r,c,s,d,z));
        }

        int ans=0;
        for(int k=0; k<C; k++){
            // 상어 잡기
            int cr=-1, cc=-1;
            for(int r=0; r<R; r++){
                if(map[r][k] != null){
                    ans += map[r][k].z;
                    map[r][k] = null;
                    cr=r;
                    cc=k;
                    break;
                }
            }

            map = new Shark[R][C];
            int size = pq.size();
            boolean[][] isFull = new boolean[R][C];
            for(int p=0; p<size; p++){
                Shark shark = pq.poll();
                if(cr!=-1 && cc!=-1 && shark.r==cr  && shark.c==cc) continue;

                Shark ns = shark.move();
                if(isFull[ns.r][ns.c]) continue;
                isFull[ns.r][ns.c]=true;
                map[ns.r][ns.c]=ns;
                pq2.add(new Shark(ns.r, ns.c, ns.s, ns.d, ns.z));
            }
            while(!pq2.isEmpty()){
                pq.add(pq2.poll());
            }
        }
        System.out.println(ans);
    }

    static class Shark implements Comparable<Shark>{
        int r,c,s,d,z;
        Shark(int r, int c, int s, int d, int z){
            super();
            this.r=r;
            this.c=c;
            this.s=s;
            this.d=d;
            this.z=z;
        }

        public Shark move(){
            int nr=this.r, nc=this.c, nd=this.d;

            if(d==1||d==2){
                this.s = this.s%(2*(R-1));
            }else{
                this.s = this.s%(2*(C-1));
            }

            for(int t=0; t<this.s; t++){
                if(nr==0 && nd==1){
                    nd=2;
                }else if(nr==R-1 && nd==2){
                    nd=1;
                }else if(nc==0 && nd==4){
                    nd=3;
                }else if(nc==C-1 && nd==3){
                    nd=4;
                }

                nr+=dr[nd];
                nc+=dc[nd];
            }
            this.r=nr;
            this.c=nc;
            this.d=nd;

            return new Shark(this.r, this.c, this.s,  this.d, this.z);
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(o.z, this.z);
        }
    }
}
