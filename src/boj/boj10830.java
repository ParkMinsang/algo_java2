package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10830 {
    static final int MOD = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ret = matpow(mat, b);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(ret[i][j]%MOD).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[][] matpow(int[][] mat, long m){
        int n = mat.length;
        int[][] ret = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ret[i][j]=mat[i][j];
            }
        }

        if(m==1) return ret;
        if(m%2>0) return matmul(matpow(mat, m-1), ret);
        int[][] half = matpow(mat, m/2);
        return matmul(half, half);
    }

    static int[][] matmul(int[][] mat1, int[][] mat2){
        int n = mat1.length;

        int[][] ret = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    ret[i][j] = (ret[i][j] + ((mat1[i][k]%MOD)*(mat2[k][j]%MOD))%MOD)%MOD;
                }
            }
        }

        return ret;
    }
}
