package boj;

import java.io.*;
import java.util.*;

public class boj5373 {
    static int[][] sidesd = {{3,5,2,4}
                        ,{2,5,3,4}
                        ,{0,5,1,4}
                        ,{0,4,1,5}
                        ,{0,2,1,3}
                        ,{0,3,1,2}};
    static int[][][] turn4d = {{{2,1,0},{2,1,0},{2,1,0},{2,1,0}},
                            {{6,7,8},{6,7,8},{6,7,8},{6,7,8}},
                            {{6,7,8},{0,3,6},{2,1,0},{8,5,2}},
                            {{2,1,0},{0,3,6},{6,7,8},{8,5,2}},
                            {{0,3,6},{0,3,6},{0,3,6},{8,5,2}},
                            {{8,5,2},{0,3,6},{8,5,2},{8,5,2}}};
    static Map<Character, Integer> sidemap;
    static char[][] cube;
    public static void main(String[] args) throws IOException{
        sidemap = new HashMap<>();
        sidemap.put('U',0); sidemap.put('D',1);
        sidemap.put('F',2); sidemap.put('B',3);
        sidemap.put('L',4); sidemap.put('R',5);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            cube = new char[6][9];
            initcube();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int i=0; i<n; i++){
                String cmd = st.nextToken();
                int side = sidemap.get(cmd.charAt(0));
                int turnd = cmd.charAt(1)=='+'?1:0;

                sideturn(side, turnd);
                turn4(side, turnd);
            }

            System.out.println(cube[0][0]+""+cube[0][1]+""+cube[0][2]);
            System.out.println(cube[0][3]+""+cube[0][4]+""+cube[0][5]);
            System.out.println(cube[0][6]+""+cube[0][7]+""+cube[0][8]);
        }
    }
    static void sideturn(int side, int turnd){
        if(turnd==1){ // 시계
            char tmp = cube[side][2];
            cube[side][2]=cube[side][0];
            cube[side][0]=cube[side][6];
            cube[side][6]=cube[side][8];
            cube[side][8]=tmp;
            tmp = cube[side][1];
            cube[side][1]=cube[side][3];
            cube[side][3]=cube[side][7];
            cube[side][7]=cube[side][5];
            cube[side][5]=tmp;
        }else{
            char tmp = cube[side][2];
            cube[side][2]=cube[side][8];
            cube[side][8]=cube[side][6];
            cube[side][6]=cube[side][0];
            cube[side][0]=tmp;
            tmp = cube[side][1];
            cube[side][1]=cube[side][5];
            cube[side][5]=cube[side][7];
            cube[side][7]=cube[side][3];
            cube[side][3]=tmp;
        }
    }

    static void turn4(int side, int turnd){
        if(turnd==1){
            char[] tmp = {cube[sidesd[side][3]][turn4d[side][3][0]]
                        , cube[sidesd[side][3]][turn4d[side][3][1]]
                        , cube[sidesd[side][3]][turn4d[side][3][2]]};
            for(int d=3; d>=1; d--){
                cube[sidesd[side][d]][turn4d[side][d][0]]
                        = cube[sidesd[side][d-1]][turn4d[side][d-1][0]];
                cube[sidesd[side][d]][turn4d[side][d][1]]
                        = cube[sidesd[side][d-1]][turn4d[side][d-1][1]];
                cube[sidesd[side][d]][turn4d[side][d][2]]
                        = cube[sidesd[side][d-1]][turn4d[side][d-1][2]];
            }
            cube[sidesd[side][0]][turn4d[side][0][0]] = tmp[0];
            cube[sidesd[side][0]][turn4d[side][0][1]] = tmp[1];
            cube[sidesd[side][0]][turn4d[side][0][2]] = tmp[2];
        }else{
            char[] tmp = {cube[sidesd[side][0]][turn4d[side][0][0]]
                    , cube[sidesd[side][0]][turn4d[side][0][1]]
                    , cube[sidesd[side][0]][turn4d[side][0][2]]};
            for(int d=0; d<3; d++){
                cube[sidesd[side][d]][turn4d[side][d][0]]
                        = cube[sidesd[side][d+1]][turn4d[side][d+1][0]];
                cube[sidesd[side][d]][turn4d[side][d][1]]
                        = cube[sidesd[side][d+1]][turn4d[side][d+1][1]];
                cube[sidesd[side][d]][turn4d[side][d][2]]
                        = cube[sidesd[side][d+1]][turn4d[side][d+1][2]];
            }
            cube[sidesd[side][3]][turn4d[side][3][0]] = tmp[0];
            cube[sidesd[side][3]][turn4d[side][3][1]] = tmp[1];
            cube[sidesd[side][3]][turn4d[side][3][2]] = tmp[2];
        }
    }

    static void initcube(){
        Arrays.fill(cube[0], 'w');
        Arrays.fill(cube[1], 'y');
        Arrays.fill(cube[2], 'r');
        Arrays.fill(cube[3], 'o');
        Arrays.fill(cube[4], 'g');
        Arrays.fill(cube[5], 'b');
    }
}
