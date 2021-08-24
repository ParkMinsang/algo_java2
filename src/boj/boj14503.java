package boj;

import java.io.*;
import java.util.*;

public class boj14503 {
    static int n, totsum;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        totsum=0;
        map = new int[n][n];

        StringTokenizer st = null;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                totsum+=map[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int d1=1; d1<n; d1++){
                    for(int d2=1; d2<n; d2++){
                        int ret = simulate(i,j,d1,d2);
                        if(ret>-1){
                            ans = Math.min(ans, ret);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static int simulate(int x, int y, int d1, int d2){
        if(x<0 || y-d1<0 || x+d1+d2>=n || y+d2>=n) return -1;

        int ret=0, sum1=0, sum2=0, sum3=0, sum4=0, sum5=0;

        for(int r=0; r<x+d1; r++){
            if(r<x){
                for(int c=0; c<=y; c++){
                    sum1+=map[r][c];
                }
            }
            else{
                for(int c=0; c<=y-(r-x+1); c++){
                    sum1+=map[r][c];
                }
            }
        }

        for(int r=0; r<=x+d2; r++){
            if(r<x){
                for(int c=y+1; c<n; c++){
                    sum2+=map[r][c];
                }
            }
            else{
                for(int c=y+(r-x+1); c<n; c++){
                    sum2+=map[r][c];
                }
            }
        }

        for(int r=x+d1; r<n; r++){
            if(r<=x+d1+d2){
                for(int c=0; c<y-d1+(r-x-d1); c++){
                    sum3+=map[r][c];
                }
            }
            else{
                for(int c=0; c<y-d1+d2; c++){
                    sum3+=map[r][c];
                }
            }
        }

        for(int r=x+d2+1; r<n; r++){
            if(r<=x+d1+d2){
                for(int c=y+d2-(r-x-d2-1); c<n; c++){
                    sum4+=map[r][c];
                }
            }
            else{
                for(int c=y-d1+d2; c<n; c++){
                    sum4+=map[r][c];
                }
            }
        }

        int[] sum = new int[5];
        sum[0]=sum1;
        sum[1]=sum2;
        sum[2]=sum3;
        sum[3]=sum4;
        sum[4]=totsum-sum1-sum2-sum3-sum4;

        Arrays.sort(sum);

        return sum[4]-sum[0];
    }
}
