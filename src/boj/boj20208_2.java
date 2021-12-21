package boj;

import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj20208_2 {
    static int n, h, sx, sy;
    static int[][] a;
    static ArrayList<Pair> list;
    static boolean[] c;
    static int ans = 0;

    static int getAbs(int a, int b, int x, int y) {
        return Math.abs(a - x) + Math.abs(b - y);
    }

    static void go(int hp, int cnt, int cx, int cy) {
        int size = list.size();
        if (hp - (getAbs(cx, cy, sx, sy)) >= 0) {
            ans = Math.max(ans, cnt);
        }
        if (hp <= 0) return;

        for (int i = 0; i < size; i++) {
            if (c[i]) continue;
            int x = list.get(i).x;
            int y = list.get(i).y;
            int distance = getAbs(x, y, cx, cy);
            if(hp<distance) continue;
            c[i] = true;
            go(hp - distance + h, cnt+1, x, y);
            c[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        list = new ArrayList<>();
        sx = 0;
        sy = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (a[i][j] == 2) {
                    list.add(new Pair(i, j));
                }
            }
        }

        int size = list.size();
        c = new boolean[size];
        go(m, 0, sx, sy);
        System.out.println(ans);
    }
}