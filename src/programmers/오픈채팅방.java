package programmers;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
    public static String[] solution(String[] record) {
        ArrayList<String> ansarr = new ArrayList<>();

        Map<String, String> map = new HashMap<>();

        for(String s : record){
            StringTokenizer st = new StringTokenizer(s," ");

            String cmd = st.nextToken();
            String uid = st.nextToken();
            String nick = st.nextToken();

            if(cmd.equals("Enter") || cmd.equals("Change")){
                map.put(uid, nick);
            }
        }

        for(String s : record){
            StringTokenizer st = new StringTokenizer(s," ");

            String cmd = st.nextToken();
            String uid = st.nextToken();
            String nick = st.nextToken();

            String curr_nick = map.get(uid);
            if(cmd.equals("Enter")){
                ansarr.add(curr_nick+"님이 들어왔습니다.");
            }
            else if(cmd.equals("Leave")){
                ansarr.add(curr_nick+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[ansarr.size()];
        for(int i=0; i<ansarr.size(); i++){
            answer[i] = ansarr.get(i);
        }
        return answer;
    }
}