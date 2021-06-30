package boj;

import java.io.*;
import java.util.*;

public class boj19236 {
    static int[] dr={-1,-1,0,1,1,1,0,-1}, dc={0,-1,-1,-1,0,1,1,1};
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[][] map = new Fish[4][4];

        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<4; j++){
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;

                map[i][j] = new Fish(num, d);
            }
        }
        ans = map[0][0].num;
        int tmpd = map[0][0].d;
        map[0][0]=null;
        func(0,0,tmpd,ans,map);
        System.out.println(ans);
    }
    static void func(int r, int c, int d, int prevans, Fish[][] prevmap){
        ans = Math.max(ans, prevans);

        Fish[][] currmap = new Fish[4][4];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(prevmap[i][j]==null) continue;
                currmap[i][j]=new Fish(prevmap[i][j].num, prevmap[i][j].d);
            }
        }

        for(int f=1; f<17; f++){
            boolean isMove = false;
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(currmap[i][j]==null) continue;
                    if(currmap[i][j].num==f){
                        isMove = true;
                        for(int t=0; t<8; t++){
                            int nr=i+dr[currmap[i][j].d];
                            int nc=j+dc[currmap[i][j].d];

                            if(nr<0 || nr>=4 || nc<0 || nc>=4 || (nr==r && nc==c)){
                                currmap[i][j].d++;
                                if(currmap[i][j].d==8) currmap[i][j].d=0;
                                continue;
                            }

                            if(currmap[nr][nc]==null){
                                currmap[nr][nc] = new Fish(currmap[i][j].num, currmap[i][j].d);
                                currmap[i][j]=null;
                            }else{
                                Fish tmp = new Fish(currmap[nr][nc].num, currmap[nr][nc].d);
                                currmap[nr][nc].num = currmap[i][j].num;
                                currmap[nr][nc].d = currmap[i][j].d;
                                currmap[i][j].num = tmp.num;
                                currmap[i][j].d = tmp.d;
                            }
                            break;
                        }
                    }
                    if(isMove) break;
                }
                if(isMove) break;
            }
        }

        for(int i=1; i<=3; i++){
            int nr=r+i*dr[d];
            int nc=c+i*dc[d];

            if(nr<0 || nr>=4 || nc<0 || nc>=4 || currmap[nr][nc]==null) continue;

            int tmpnum = currmap[nr][nc].num;
            int tmpd = currmap[nr][nc].d;
            currmap[nr][nc] = null;
            func(nr,nc,tmpd, prevans+tmpnum,currmap);
            currmap[nr][nc] = new Fish(tmpnum, tmpd);
        }
    }

    static class Fish{
        int num, d;
        Fish(int num, int d){
            super();
            this.num=num;
            this.d=d;
        }
    }
}
