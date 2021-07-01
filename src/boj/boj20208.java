package boj;

import java.io.*;
import java.util.*;

public class boj20208 {
    static int n,m,h,ans;
    static boolean[] isVisited;
    static Point[] points;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ArrayList<Point> arr = new ArrayList<>();
        Point start=null;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val==1){
                    start = new Point(i,j);
                }else if(val==2){
                    arr.add(new Point(i,j));
                }
            }
        }
        isVisited = new boolean[arr.size()+1];
        points = new Point[arr.size()+1];
        points[0]=start;
        for(int i=1; i<points.length; i++){
            points[i] = arr.get(i-1);
        }

        ans = 0;
        backtracking(0,m, 0);
        System.out.println(ans);
    }
    static void backtracking(int previdx, int energy, int cnt){
        Point curr = points[previdx];

        if(dist(points[previdx], points[0])<=energy){
            ans = Math.max(ans, cnt);
        }

        for(int i=1; i<isVisited.length; i++){
            if(!isVisited[i]){
                int need = dist(points[i], curr);
                if(energy < need) continue;
                isVisited[i]=true;
                backtracking(i, energy-need+h,cnt+1);
                isVisited[i]=false;
            }
        }
    }

    static int dist(Point p1, Point p2){
        return Math.abs(p1.r-p2.r)+Math.abs(p1.c-p2.c);
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
