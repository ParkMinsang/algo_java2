package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1780 {
    static int[][] A;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n][n];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = new int[3];
        solve(0,0,n);
        for(int an : ans) System.out.println(an);
    }
    static void solve(int r, int c, int n){
        int prev = A[r][c];
        int nn=n/3;
        for(int i=r; i<r+n; i++){
            for(int j=c; j<c+n; j++){
                if(A[i][j]!=prev){
                    doSolve(r, c, nn);
                    return;
                }
                prev = A[i][j];
            }
        }

        if(prev == -1) ans[0]++;
        else if(prev==0) ans[1]++;
        else ans[2]++;
    }

    static void doSolve(int r, int c, int n){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                solve(r+(n*i), c+(n*j), n);
            }
        }
    }
}
