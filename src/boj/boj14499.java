package boj;

import java.io.*;
import java.util.*;

public class boj14499 {
    static int[] dr={0,0,0,-1,1}, dc={0,1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int sr=Integer.parseInt(st.nextToken());
        int sc=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[] commands = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<k; i++){
            commands[i]=Integer.parseInt(st.nextToken());
        }

        Dice dice = new Dice();
        dice.r=sr;
        dice.c=sc;

        for(int i=0; i<k; i++){
            int nr=dice.r+dr[commands[i]];
            int nc=dice.c+dc[commands[i]];

//            System.out.println(nr+" "+nc);

            if(nr<0 || nr>=n || nc<0 || nc>=m) {
                continue;
            }

            dice.r=nr; dice.c=nc;
            dice.move(commands[i]);

            if(map[nr][nc]==0) map[nr][nc]=dice.down;
            else{
                dice.down = map[nr][nc];
                map[nr][nc]=0;
            }

            System.out.println(dice.up);
        }



    }
    static class Dice{
        int up,down,front,back,left,right,r,c;
        Dice(){
            up=0;
            down=0;
            front=0;
            back=0;
            left=0;
            right=0;
        }

        public void move(int d){
            if(d==1){
                goRight();
            }else if(d==2){
                goLeft();
            }else if(d==3){
                goFront();
            }else if(d==4){
                goBack();
            }
        }

        public void goFront(){
            int tmp=front;
            front=up;
            up=back;
            back=down;
            down=tmp;
        }

        public void goLeft(){
            int tmp=left;
            left=up;
            up = right;
            right=down;
            down = tmp;
        }

        public void goRight(){
            int tmp=right;
            right=up;
            up=left;
            left=down;
            down=tmp;
        }

        public void goBack(){
            int tmp=back;
            back=up;
            up=front;
            front=down;
            down=tmp;
        }
    }
}
