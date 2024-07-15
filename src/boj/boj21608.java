package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21608 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[] score = {0, 1, 10, 100, 1000};

    static int n;

    static int[][] seats;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seats = new int[n][n];

        var studentCount = n * n;
        var students = new HashMap<Integer, Student>();
        StringTokenizer st = null;
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            var num = Integer.parseInt(st.nextToken());
            var like1 = Integer.parseInt(st.nextToken());
            var like2 = Integer.parseInt(st.nextToken());
            var like3 = Integer.parseInt(st.nextToken());
            var like4 = Integer.parseInt(st.nextToken());

            var student = new Student(num, like1, like2, like3, like4);
            students.put(num, student);
            var getSeat = findMostSeat(student);
            seats[getSeat.r][getSeat.c] = student.number;
        }

        int ret = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int likeCount = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                        continue;
                    }
                    var student = students.get(seats[r][c]);
                    if (student.isLike(seats[nr][nc])) {
                        likeCount++;
                    }
                }

                ret += score[likeCount];
            }
        }
        System.out.println(ret);
    }

    static Seat findMostSeat(Student student) {
        int mostValue = 0;
        int mostEmpty = 0;

        int targetR = 0;
        int targetC = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (seats[r][c] == 0) {
                    int value = 0;
                    int emptyCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                            continue;
                        }

                        if (seats[nr][nc] == 0) {
                            emptyCount++;
                        } else if (student.isLike(seats[nr][nc])) {
                            value++;
                        }
                    }

                    if (mostValue < value) {
                        targetR = r;
                        targetC = c;
                        mostValue = value;
                    } else if (mostValue == value && mostEmpty < emptyCount) {
                        targetR = r;
                        targetC = c;
                        mostEmpty = emptyCount;
                    }
                }
            }
        }

        return new Seat(targetR, targetC);
    }

    static class Student {
        int number;
        Set<Integer> likeFriends;

        public Student(int number, int l1, int l2, int l3, int l4) {
            this.number = number;
            likeFriends = new HashSet<>();
            likeFriends.addAll(List.of(l1, l2, l3, l4));
        }

        boolean isLike(int num) {
            return likeFriends.contains(num);
        }
    }

    static class Seat {
        int r, c;

        public Seat(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
