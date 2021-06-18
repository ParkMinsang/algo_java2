package boj;

import java.io.*;
import java.util.*;

public class boj9328 {
    static int[] dr={-1,0,1,0}, dc={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine()," ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            int cntkey=0, startkey=0, startdoc=0;
            Map<Integer, Integer> keymap = new HashMap<>();
            ArrayList<Point> startpoint = new ArrayList<>();
            for(int i=0; i<h; i++){
                String inputline = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = inputline.charAt(j);
                    if(map[i][j]>='A' && map[i][j]<='Z'){
                        if(!keymap.containsKey(map[i][j]-'A')){
                            keymap.put((map[i][j]-'A'), cntkey);
                            cntkey++;
                        }
                    }
                    else if(map[i][j]>='a' && map[i][j]<='z'){
                        if(!keymap.containsKey(map[i][j]-'a')){
                            keymap.put(map[i][j]-'a', cntkey);
                            cntkey++;
                        }
                    }
                    else if(((i==0 || i==h-1) || (j==0 || j==w-1)) && map[i][j]=='.'){
                        startpoint.add(new Point(i,j,0));
                    }
                    else if(map[i][j]=='$'){
                        startdoc++;
                    }
                }
            }
            String startkeyinput = br.readLine();
            if(!startkeyinput.equals("0")){
                for(int c=0; c<startkeyinput.length(); c++){
                    if(keymap.containsKey(startkeyinput.charAt(c)-'a')){
                        startkey |= (1<<keymap.get(startkeyinput.charAt(c)-'a'));
                    }
                }
            }
            boolean[][][] isVisited = new boolean[h][w][1<<cntkey];
            Queue<Point> q = new LinkedList<>();
            for(Point start : startpoint){
                q.add(new Point(start.r, start.c, startkey));
                isVisited[start.r][start.c][startkey]=true;
            }
            while(!q.isEmpty()){
                Point curr = q.poll();
                for(int d=0; d<4; d++){
                    int nr = curr.r+dr[d];
                    int nc = curr.c+dc[d];
                    if(nr<0 || nr>=h || nc<0 || nc>=w || map[nr][nc]=='*') continue;
                    if(map[nr][nc]=='.' && !isVisited[nr][nc][curr.key]){
                        isVisited[nr][nc][curr.key]=true;
                        q.add(new Point(nr,nc,curr.key));
                    }
                    else if(map[nr][nc]>='A' && map[nr][nc]<='Z'
                            && (curr.key&(1<<keymap.get(map[nr][nc]-'A')))!=0
                            && !isVisited[nr][nc][curr.key]){
                        isVisited[nr][nc][curr.key] = true;
                        q.add(new Point(nr,nc,(curr.key|(1<<keymap.get(map[nr][nc]-'A')))));
                    }
                    else if(map[nr][nc]>='a' && map[nr][nc]<='z'
                            && !isVisited[nr][nc][curr.key]){
                        isVisited[nr][nc][curr.key]=true;
                        if((curr.key&(1<<keymap.get(map[nr][nc]-'a')))==0){
                            int newkey = (curr.key|(1<<keymap.get(map[nr][nc]-'a')));
                            for(Point point : startpoint){
                                if(!isVisited[point.r][point.c][newkey]){
                                    isVisited[point.r][point.c][newkey]=true;
                                    q.add(new Point(point.r, point.c, newkey));
                                }
                            }
                            q.add(new Point(nr,nc,newkey));
                        }else{
                            q.add(new Point(nr,nc,(curr.key|(1<<keymap.get(map[nr][nc]-'a')))));
                        }
                    }
                    else if(map[nr][nc]=='$'){
                        map[nr][nc]='*';
                    }
                }
            }

            int stoledoc=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]=='$'){
                        stoledoc++;
                    }
                }
            }
            System.out.println(startdoc-stoledoc);
        }
    }

    static class Point{
        int r,c,key;
        Point(int r, int c, int key){
            this.r=r;
            this.c=c;
            this.key=key;
        }
    }
}
