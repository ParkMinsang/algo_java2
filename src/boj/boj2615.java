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
        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                if(map[i][j]!=0){
                    int ret=isMaked(i,j);
                    if(ret!=0){
                        System.out.println(map[i][j]);
                        if(ret==1){
                            System.out.println((i+1)+" "+(j+1));
                        }else if(ret==2){
                            System.out.println((i+5)+" "+(j-5));
                        }
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static int isMaked(int r, int c){
        int color = map[r][c];

        if(r>0 && map[r-1][c]==color) return 0;
        if(c>0 && map[r][c-1]==color) return 0;
        if(r>0&&c>0 && map[r-1][c-1]==color) return 0;
        if(r>0&&c<18 && map[r-1][c+1]==color) return 0;

        //->
        boolean isH = true;
        for(int i=c; i<c+5; i++){
            if(i>=19 || map[r][i] != color){
                isH=false;
                break;
            }
        }
        if(isH) return 1;

        //v
        boolean isV = true;
        for(int i=r; i<r+5; i++){
            if(i>=19 || map[i][c] != color){
                isV=false;
                break;
            }
        }
        if(isV) return 1;

        //\
        boolean isS = true;
        for(int i=0; i<5; i++){
            if(r+i>=19 || c+i>=19 || map[r+i][c+i]!=color){
                isS=false;
                break;
            }
        }
        if(isS) return 1;

        ///
        boolean isS2 = true;
        for(int i=0; i<5; i++){
            if(r+i>=19 || c-i<0 || map[r+i][c-i] != color){
                isS2 = false;
                break;
            }
        }
        if(isS2) return 2;

        return 0;
    }

}
