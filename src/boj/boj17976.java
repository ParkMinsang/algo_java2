package boj;

import java.io.*;
import java.util.*;

public class boj17976 {
    static int n;
    static Th[] ths;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ths = new Th[n];
        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            ths[i] = new Th(x,l);
        }
        Arrays.sort(ths);

        long lt=0, rt=2000000000, mt=0, ans=0;
        while(lt<=rt){
            mt = (lt+rt)/2;
            if(isPos(mt)){
                ans=mt;
                lt=mt+1;
            }else{
                rt=mt-1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPos(long mt){
        long prev=ths[0].x;
        for(int i=1; i<n; i++){
            if(prev+mt > ths[i].x+ths[i].l) return false;
            prev = Math.max(prev+mt, ths[i].x);
        }
        return true;
    }

    static class Th implements Comparable<Th>{
        int x,l;
        Th(int x, int l){
            super();
            this.x=x;
            this.l=l;
        }
        @Override
        public int compareTo(Th o) {
            return Integer.compare(this.x, o.x);
        }
    }
}
