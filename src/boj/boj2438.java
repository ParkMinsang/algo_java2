package boj;

import java.util.Scanner;

public class boj2438{

    static StringBuilder sb = new StringBuilder();

    public static void star(int idx,int n) {
        if(idx>n) return;

        for(int i=0; i<idx; i++){
            sb.append("*");
        }
        sb.append("\n");

        star(idx+1, n);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        star(1,number);
        System.out.println(sb);
    }
}