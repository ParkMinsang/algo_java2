package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2448 {
    static char[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int size = 2*n-1;
        A = new char[n][size];
        for(int i=0; i<n; i++) Arrays.fill(A[i],' ');
        drawing(0,n-1,n);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<size; j++){
                sb.append(A[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void drawing(int r, int c, int n){
        if(n==3){
            drawTri(r, c);
            return;
        }

        int nn = n/2;
        drawing(r, c, nn);
        drawing(r+nn, c-nn, nn);
        drawing(r+nn, c+nn, nn);
    }

    static void drawTri(int r, int c){
        A[r][c]='*';
        A[r+1][c-1]='*';A[r+1][c+1]='*';
        A[r+2][c-2]='*';A[r+2][c-1]='*';A[r+2][c]='*';A[r+2][c+1]='*';A[r+2][c+2]='*';
    }
}
