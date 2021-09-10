package programmers;

import java.util.*;

public class 순위 {
    public static void main(String[] args) {
        solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;

        ArrayList<Integer>[] winarr = new ArrayList[n+1], losearr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            winarr[i] = new ArrayList<>();
            losearr[i] = new ArrayList<>();
        }

        for(int[] ret : results){
            winarr[ret[0]].add(ret[1]);
            losearr[ret[1]].add(ret[0]);
        }

        int[] wincnt = new int[n+1], losecnt = new int[n+1];

        for(int i=1; i<n+1; i++){
            Queue<Integer> q = new LinkedList<>();
            boolean[] isVisited = new boolean[n+1];
            q.add(i); isVisited[i]=true;

            while(!q.isEmpty()){
                wincnt[i]++;

                int curr = q.poll();
                for(int next : winarr[curr]){
                    if(isVisited[next]) continue;
                    isVisited[next]=true;
                    q.add(next);
                }
            }

            isVisited = new boolean[n+1];
            q.add(i); isVisited[i]=true;

            while(!q.isEmpty()){
                losecnt[i]++;

                int curr = q.poll();
                for(int next : losearr[curr]){
                    if(isVisited[next]) continue;
                    isVisited[next]=true;
                    q.add(next);
                }
            }
        }

        for(int i=1; i<n+1; i++){
            if(wincnt[i]+losecnt[i]==n+1) answer++;
        }

        return answer;
    }
}