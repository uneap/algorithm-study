import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ranking_queue {
    // room - players(list<player>), room check
    // player - level, name, comparable

    static int limit;

    public static class Room {

        Player chief;
        List<Player> players;

        public Room(Player player) {
            this.chief = player;
            players = new ArrayList<>();
            players.add(chief);
        }

        public boolean full() {
            return players.size() >= limit;
        }

        public boolean possibleEnter(Player player) {
            if (full()) {
                return false;
            }
            return chief.possibleEnter(player);
        }

        public void enter(Player player) {
            players.add(player);
        }

        public void print() {
            if(full()) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            Collections.sort(players);
            for(Player player : players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }

    public static class Player implements Comparable<Player> {

        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        public boolean possibleEnter(Player player) {
            return player.level <= level + 10 && player.level >= level - 10;
        }

        @Override
        public int compareTo(Player player) {
            return name.compareTo(player.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = parseInt(st.nextToken());
        limit = parseInt(st.nextToken());
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            players.add(new Player(parseInt(st.nextToken()), st.nextToken()));
        }
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            Player player = players.get(i);
            boolean possible = false;
            for(Room room : rooms) {
                if (room.possibleEnter(player)) {
                    room.enter(player);
                    possible = true;
                    break;
                }
            }
            if(!possible) {
                rooms.add(new Room(player));
            }
        }
        for(Room room : rooms) {
            room.print();
        }
    }
}
