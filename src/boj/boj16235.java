package boj;

import java.io.*;
import java.util.*;

/**
 * fail code
 * */

public class boj16235 {
    static int[] dr={-1,-1,-1,0,0,1,1,1}, dc={-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][n];
        int[][] A = new int[n][n];
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        PriorityQueue<Tree> tmppq = new PriorityQueue<>();
        Queue<Tree> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            Arrays.fill(land[i],5);
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            pq.add(new Tree(r,c,age));
        }

        for(int t=0; t<k; t++){
            //spring
            while(!pq.isEmpty()){
                Tree tree = pq.poll();
                if(land[tree.r][tree.c] >= tree.age){
                    land[tree.r][tree.c]-=tree.age;
                    tmppq.add(new Tree(tree.r, tree.c, tree.age+1));
                }else{
                    q.add(new Tree(tree.r, tree.c, tree.age));
                }
            }
            //summer
            while(!q.isEmpty()){
                Tree tree = q.poll();
                land[tree.r][tree.c] += tree.age/2;
            }
            //fall
            while(!tmppq.isEmpty()){
                Tree tree = tmppq.poll();
                if(tree.age%5==0){
                    for(int d=0; d<8; d++){
                        int nr=tree.r+dr[d];
                        int nc=tree.c+dc[d];

                        if(nr<0 || nr>=n || nc<0 || nc>=n) continue;

                        pq.add(new Tree(nr,nc,1));
                    }
                }
                pq.add(new Tree(tree.r, tree.c, tree.age));
            }
            //winter
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    land[i][j] += A[i][j];
                }
            }
        }
        System.out.println(pq.size());
    }

    static class Tree implements Comparable<Tree>{
        int r,c,age;
        Tree(int r, int c, int age){
            this.r=r;
            this.c=c;
            this.age=age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
