package boj;

import java.io.*;
import java.util.*;

public class boj20056 {
    static int[] dr={-1,-1,0,1,1,1,0,-1}, dc={0,1,1,1,0,-1,-1,-1}, dt={0,2,4,6}, dd={1,3,5,7};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<FB> q = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q.add(new FB(r,c,m,s,d));
        }

        ArrayList<FB>[][] map = new ArrayList[n][n];
        for(int k=0; k<K; k++){
            int size = q.size();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = new ArrayList<>();
                }
            }

            for(int t=0; t<size; t++){
                FB curr = q.poll();

                int nr = curr.r+dr[curr.d]*curr.s;
                int nc = curr.c+dc[curr.d]*curr.s;

                if(nr<0) nr = ((nr%n)+n)%n;
                else nr %= n;

                if(nc<0) nc = ((nc%n)+n)%n;
                else nc %= n;

                map[nr][nc].add(new FB(nr, nc, curr.m, curr.s, curr.d));
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j].size()>1){
                        int[] ms = getNext(map[i][j]);
                        if(ms[0]==0) continue;

                        // di ? dt:dd
                        boolean di = isSame(map[i][j]);
                        for(int f=0; f<4; f++){
                            q.add(new FB(i, j, ms[0], ms[1], di?dt[f]:dd[f]));
                        }
                    }else if(map[i][j].size()==1){
                        q.add(map[i][j].get(0));
                    }
                }
            }
        }

        int ans = 0;
        for(FB fb : q){
            ans+=fb.m;
        }
        System.out.println(ans);

    }
    public static int[] getNext(List<FB> list){
        int retM=0;
        int retS=0;

        for(FB fb : list){
            retM+=fb.m;
            retS+=fb.s;
        }
        return new int[] {retM/5, retS/list.size()};
    }

    public static boolean isSame(List<FB> list){
        boolean isOdd = false, isEven = false;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).d%2==0){
                if(isOdd) return false;
                isEven = true;
            }else{
                if(isEven) return false;
                isOdd = true;
            }
        }
        return true;
    }

    public static class FB{
        public int r,c,m,s,d;

        public FB(int r, int c, int m, int s, int d){
            this.r=r;
            this.c=c;
            this.m=m;
            this.s=s;
            this.d=d;
        }
    }
}
