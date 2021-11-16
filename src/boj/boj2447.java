package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2447 {
    static char[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new char[n][n];

        drawing(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(A[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void drawing(int r, int c, int n){
        if(n==1){
            A[r][c]='*';
            return;
        }

        int nn=n/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) fill0(r+nn, c+nn, nn);
                else drawing(r+(i*nn), c+(j*nn), nn);
            }
        }
    }

    static void fill0(int r, int c, int n){
        for(int i=r; i<r+n; i++){
            for(int j=c; j<c+n; j++){
                A[i][j]=' ';
            }
        }
    }
}
