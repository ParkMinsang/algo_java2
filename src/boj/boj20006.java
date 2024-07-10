package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20006 {

    static int roomSize;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var p = Integer.parseInt(st.nextToken());
        roomSize = Integer.parseInt(st.nextToken());

        List<Room> currentRooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            var level = Integer.parseInt(st.nextToken());
            var name = st.nextToken();

            var member = new Member(level, name);

            boolean isEnter = false;
            for (Room room : currentRooms) {
                if (room.ableEnter(member)) {
                    room.addMember(member);
                    isEnter = true;
                    break;
                }
            }

            if (!isEnter) {
                currentRooms.add(new Room(member));
            }
        }

        var ans = new StringBuilder();
        for (Room currentRoom : currentRooms) {
            ans.append(currentRoom.toString()).append('\n');
        }
        ans.setLength(ans.length() - 1);
        System.out.println(ans);
    }

    static class Member {
        int level;
        String name;

        public Member(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%d %s", level, name);
        }
    }

    static class Room {

        List<Member> members = new ArrayList<>();
        Member maker;

        Room(Member maker) {
            this.maker = maker;
            members.add(maker);
        }

        boolean ableEnter(Member member) {
            return Math.abs(member.level - maker.level) <= 10 && members.size() < roomSize;
        }

        void addMember(Member member) {
            members.add(member);
        }

        boolean isStarted() {
            return members.size() == roomSize;
        }

        @Override
        public String toString() {
            members.sort(Comparator.comparing(m -> m.name));
            var sb = new StringBuilder();
            if (isStarted()) {
                sb.append("Started!").append('\n');
            } else {
                sb.append("Waiting!").append('\n');
            }
            for (int i = 0; i < members.size(); i++) {
                sb.append(members.get(i));
                if (i != members.size() - 1) {
                    sb.append('\n');
                }
            }
            return sb.toString();
        }
    }
}
