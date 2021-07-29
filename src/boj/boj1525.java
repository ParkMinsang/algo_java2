package boj;

import java.io.*;
import java.util.*;

public class boj1525 {
    static Set<Integer> set;
    static int[] dd = {-1,1,-3,3};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();

        StringTokenizer st = null;
        int start = 0;
        char[] startarr = new char[9];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                char c = st.nextToken().charAt(0);
                start*=10;
                start+=c-'0';
                startarr[i*3+j]=c;
            }
        }

        Queue<char[]> q = new LinkedList<>();
        set.add(start);
        q.add(startarr);
        int time=0, qsize=0;
        while(!q.isEmpty() && !set.contains(123456780)){
            time++;
            qsize = q.size();
            for(int k=0; k<qsize; k++){
                char[] curr = q.poll();
                int idx=0;
                for(int i=0; i<9; i++){
                    idx=i;
                    if(curr[i]=='0') break;
                }

                for(int d=0; d<4; d++){
                    if(idx+dd[d]<0 || idx+dd[d]>=9) continue;
                    if(idx%3==0 && d==0) continue;
                    if(idx%3==2 && d==1) continue;

                    char[] tmp = new char[9];
                    for(int i=0; i<9; i++) tmp[i]=curr[i];
                    char tmpc = tmp[idx+dd[d]];
                    tmp[idx+dd[d]]=tmp[idx];
                    tmp[idx]=tmpc;

                    int tmpint = Integer.parseInt(new String(tmp));
                    if(!set.contains(tmpint)){
                        set.add(tmpint);
                        q.add(tmp);
                    }
                }

            }
        }
        System.out.println(set.contains(123456780)?time:-1);
    }
}
