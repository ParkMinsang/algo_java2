package programmers;

import java.util.*;

public class 보석쇼핑 {
    static Map<String, Integer> gemidx;
    static Set<String> gemset;
    public static void main(String[] args) {
        String[] gems = {"A","B","B","B","B","B","B","C","B","A"};
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        gemidx = new HashMap<>();
        gemset = new HashSet<>();

        int cnt=0;
        for(String gem : gems){
            if(gemset.add(gem)){
                gemidx.put(gem, cnt++);
            }
        }

        Map<String, Integer> gemcnt = new HashMap<>();

        int start=0, end=0;
        int left=0, right=0, anslength = gems.length+1;
        while(true){
            if(end==gems.length && gemcnt.size()<cnt) break;

            // 보석 부족
            if(gemcnt.size()<cnt){
                gemcnt.put(gems[end], gemcnt.get(gems[end])==null?1 : 1+gemcnt.get(gems[end]));
                end++;
            }else {
                int startcnt = gemcnt.get(gems[start]);
                if (startcnt == 1) {
                    gemcnt.remove(gems[start]);
                }else{
                    gemcnt.put(gems[start], startcnt-1);
                }
                start++;
            }

            if (gemcnt.size()==cnt && end - start < anslength) {
                anslength = end - start;
                left = start+1;
                right = end-1+1;
            }
        }

        int[] answer = new int[]{left, right};
        return answer;
    }


}
