package boj;

import java.util.*;

public class atest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("12345");

        StringBuilder sb2 = new StringBuilder(sb);
        sb.append("6789");
        System.out.println(sb2);

    }
}
