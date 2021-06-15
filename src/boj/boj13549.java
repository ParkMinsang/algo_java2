package boj;

import java.io.*;
import java.util.*;

public class boj13549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[100001];
        Queue<Integer> currq = new LinkedList<>();
        Queue<Integer> nextq = new LinkedList<>();

        isVisited[n]=true;
        currq.add(n);

        int time=0, x=0;
        while(!isVisited[k]){
            while(!isVisited[k] && !currq.isEmpty()){
                x = currq.poll();
                for(int i=(x<<1); i<100001; i<<=1){
                    if(i==0 || isVisited[i]) break;
                    if(!isVisited[i]){
                        isVisited[i]=true;
                        currq.add(i);
                    }
                    if(i==k){
                        System.out.println(time);
                        System.exit(0);
                    }
                }
                if(x+1<100001 && !isVisited[x+1]){
                    isVisited[x+1]=true;
                    nextq.add(x+1);
                }
                if(x-1>=0 && !isVisited[x-1]){
                    isVisited[x-1]=true;
                    nextq.add(x-1);
                }
            }
            time++;
            while(!isVisited[k] && !nextq.isEmpty()){
                x = nextq.poll();
                isVisited[x]=true;
                currq.add(x);
            }
        }
        System.out.println(time);
    }

}