package boj;

import java.io.*;
import java.util.*;

public class boj16434 {
    static int n;
    static long Hatk;
    static int[][] dunjeon;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        Hatk = Long.parseLong(st.nextToken());

        dunjeon = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            dunjeon[i][0] = Integer.parseInt(st.nextToken());
            dunjeon[i][1] = Integer.parseInt(st.nextToken());
            dunjeon[i][2] = Integer.parseInt(st.nextToken());
        }

        long lt=1, rt=1000001L*1000000*n, mt=0, ans=0;
        while(lt<=rt){
            mt = ((long)lt+rt)/2;
            if(isPos(mt)){
                ans = mt;
                rt = mt-1;
            }else{
                lt = mt+1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPos(long mt){
        long hp=mt, atk=Hatk;

        for(int i=0; i<n; i++){
            if(dunjeon[i][0]==1){
                hp -= ((long)dunjeon[i][2]/atk + (dunjeon[i][2]%atk==0?0:1)-1)*dunjeon[i][1];

                if(hp<=0) return false;
            }else{
                atk+=dunjeon[i][1];
                hp = Math.min(hp+dunjeon[i][2],mt);
            }
        }
        return true;
    }
}
