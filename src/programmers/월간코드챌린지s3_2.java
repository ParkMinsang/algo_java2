package programmers;

import java.util.*;

public class 월간코드챌린지s3_2 {
    static int n, m;
    static Node[][] map;
    public static void main(String[] args) {
        String[] grid = {"R","R"};

        System.out.println(Arrays.toString(solution(grid)));
    }

    public static int[] solution(String[] grid){
        int[] answer;

        n = grid.length;
        m = grid[0].length();

        map = new Node[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = new Node(grid[i].charAt(j));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int d=0; d<4; d++){
                    if(!map[i][j].isIn[d]){
                        ans.add(func(i, j, d, 1));
                    }
                }
            }
        }

        answer = new int[ans.size()];
        for(int k=0; k<ans.size(); k++){
            answer[k]=ans.get(k);
        }
        Arrays.sort(answer);
        return answer;
    }
    static int func(int r, int c, int d, int leng){
//        System.out.println(r+" "+c+" "+d+" "+leng);

        //맵 밖으로 나감
        if(r==-1) return func(n-1, c, 3, leng);
        if(c==-1) return func(r, m-1, 2, leng);
        if(r==n) return func(0, c, 1, leng);
        if(c==m) return func(r, 0, 0, leng);

        //사이클 완성
        if(map[r][c].isIn[d]) return leng-1;
        map[r][c].isIn[d]=true;

        if(d==0){
            if(map[r][c].data=='S'){
                return func(r, c+1, 0, leng+1);
            }
            else if(map[r][c].data=='L'){
                return func(r-1, c, 3, leng+1);
            }
            else { //(map[r][c].data == 'R')
                return func(r+1, c, 1, leng+1);
            }
        }
        else if(d==1){
            if(map[r][c].data=='S'){
                return func(r+1, c, 1, leng+1);
            }
            else if(map[r][c].data=='L'){
                return func(r, c+1, 0, leng+1);
            }
            else { //(map[r][c].data == 'R')
                return func(r, c-1, 2, leng+1);
            }
        }
        else if(d==2){
            if(map[r][c].data=='S'){
                return func(r, c-1, 2, leng+1);
            }
            else if(map[r][c].data=='L'){
                return func(r+1, c, 1, leng+1);
            }
            else { //(map[r][c].data == 'R')
                return func(r-1, c, 3, leng+1);
            }
        }
        else { //d==3
            if(map[r][c].data=='S'){
                return func(r-1, c, 3, leng+1);
            }
            else if(map[r][c].data=='L'){
                return func(r, c-1, 2, leng+1);
            }
            else { //(map[r][c].data == 'R')
                return func(r, c+1, 0, leng+1);
            }
        }
    }

    static class Node{
        char data;
        boolean[] isIn;

        Node(char data){
            this.data=data;
            isIn = new boolean[4];
        }
    }
}
