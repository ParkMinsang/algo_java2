package programmers;

import java.util.Arrays;

public class 정수삼각형 {
    static int n;
    static int[][] tri, dp;
    public static void main(String[] args) {

    }

    public int solution(int[][] triangle) {
        n = triangle.length;
        tri = triangle;
        dp = new int[n][1<<(n-1)];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int answer = func(0,0);
        return answer;
    }

    static int func(int idx, int point){
        if(idx==n) return 0;
        if(dp[idx][point]!=-1) return dp[idx][point];

        int ret = 0;
        ret = Math.max(func(idx+1, point), func(idx+1, point+1))+tri[idx][point];

        dp[idx][point]=ret;
        return dp[idx][point];
    }
}
