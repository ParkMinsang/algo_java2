package programmers;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {

    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        boolean[] isVisited = new boolean[n+1];
        for(int i=0; i<n+1; i++) arr[i]=new ArrayList<>();

        for(int[] ed : edge){
            arr[ed[0]].add(ed[1]);
            arr[ed[1]].add(ed[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int size=0;
        q.add(1);
        isVisited[1]=true;

        while(!q.isEmpty()){
            size = q.size();

            for(int i=0; i<size; i++){
                int curr = q.poll();

                for(int next : arr[curr]){
                    if(isVisited[next]) continue;
                    isVisited[next]=true;
                    q.add(next);
                }
            }
        }

        System.out.println(size);

        return answer;
    }
}
