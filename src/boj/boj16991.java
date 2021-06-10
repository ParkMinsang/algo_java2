package boj;

import java.io.*;
import java.util.*;

public class boj16991 {
    static int n;
    static Point[] points;
    static double[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            points[i] = new Point(r,c);
        }
        dp = new double[1<<n][n];

        System.out.println(func(1,0));
    }
    static double func(int path, int prev){
        if(path == ((1<<n)-1)){
            return dist(points[prev], points[0]);
        }
        if(dp[path][prev] != 0) return dp[path][prev];
        double ret = 999999999;
        for(int i=1; i<n; i++){
            if((path & (1<<i)) != 0) continue;
            ret = Math.min(ret, dist(points[prev], points[i])+func(path|(1<<i), i));
        }
        dp[path][prev] = ret;
        return dp[path][prev];
    }
    static double dist(Point city1, Point city2){
        double distance = (city1.r-city2.r)*(city1.r-city2.r);
        distance += (city1.c-city2.c)*(city1.c-city2.c);
        return Math.sqrt(distance);
    }

    static class Point{
        int r,c;
        Point(int r, int c){
            super();
            this.r=r;
            this.c=c;
        }
    }
}
