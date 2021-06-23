package boj;

import java.io.*;
import java.util.*;

public class boj17140 {
    static int[][] board;
    static int R,C,k, rSize, cSize;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        board = new int[100][100];
        rSize = 3; cSize =3;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time=0;
        for(int t=0; t<101; t++) {
            if (rSize >= R && cSize >= C && board[R][C] == k) break;
            time++;
            if (rSize >= cSize) {
                Rsort();
            } else {
                Csort();
            }
        }

        if(rSize >= R && cSize >= C && board[R][C] == k){
            System.out.println(time);
        }else{
            System.out.println(-1);
        }

    }
    static void Rsort(){
        int newcSize=0;
        for(int i=0; i<rSize; i++){
            ArrayList<Pair> pairs = new ArrayList<>();
            int[] tmp = new int[101];

            for(int j=0; j<cSize; j++){
                tmp[board[i][j]]++;
            }

            for(int j=1; j<101; j++){
                if(tmp[j]!=0){
                    pairs.add(new Pair(j, tmp[j]));
                }
            }

            Collections.sort(pairs);

            newcSize = Math.max(newcSize, pairs.size()*2);
            if(newcSize>100) newcSize=100;

            int idx=0;
            for(Pair pair : pairs){
                board[i][idx]=pair.val;
                idx++;

                board[i][idx]=pair.cnt;
                idx++;
                if(idx>100) break;
            }

            for(int j=idx; j<100; j++){
                board[i][j] = 0;
            }
        }
        cSize = newcSize;
    }

    static void Csort(){
        int newrSize=0;
        for(int i=0; i<cSize; i++){
            ArrayList<Pair> pairs = new ArrayList<>();
            int[] tmp = new int[101];

            for(int j=0; j<rSize; j++){
                tmp[board[j][i]]++;
            }

            for(int j=1; j<101; j++){
                if(tmp[j]!=0){
                    pairs.add(new Pair(j, tmp[j]));
                }
            }

            Collections.sort(pairs);
            newrSize = Math.max(newrSize, pairs.size()*2);
            if(newrSize>100) newrSize=100;

            int idx=0;
            for(Pair pair : pairs){
                board[idx][i]=pair.val;
                idx++;

                board[idx][i]=pair.cnt;
                idx++;
                if(idx>100) break;
            }

            for(int j=idx; j<100; j++){
                board[j][i]=0;
            }
        }
        rSize = newrSize;
    }

    static class Pair implements Comparable<Pair>{
        int val, cnt;
        Pair(int val, int cnt){
            super();
            this.val=val;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.cnt!=o.cnt){
                return Integer.compare(this.cnt, o.cnt);
            }
            else{
                return Integer.compare(this.val, o.val);
            }
        }
    }
}
