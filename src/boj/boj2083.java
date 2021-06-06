package boj;

import java.io.*;
import java.util.*;

public class boj2083 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String name = null;
        int age=0, weight=0;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            name = st.nextToken();
            age = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            if(name.equals("#") && age==0 && weight==0) break;

            if(age>17 || weight>=80){
                System.out.println(name + " " + "Senior");
            }else{
                System.out.println(name+ " "+ "Junior");
            }
        }

    }
}
