import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
// 1 2 3 4
// 1 2 3 4
// 1 2 3 4
// 1 2 3 4
public class 상어초등학교 {
    static class Node {
        int[] friends;

        public Node( int... friends) {
            this.friends = friends;
        }
    }

    static class Location implements Comparable<Location> {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isNear(Location location) {
            return Math.abs(this.x - location.x) + Math.abs(this.y - location.y) == 1;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Location) {
                Location location = (Location) o;
                return this.x == location.x && this.y == location.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x , this.y);
        }

        @Override
        public int compareTo(Location o) {
            if(this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    static int[] satisfaction = {0,1,10,100,1000};
    static Location[] locations;
    static Node[] nodes;
    static boolean[][] visit;
    static int N;
    static int[] directX = {0,0,1,-1};
    static int[] directY = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        locations = new Location[N*N + 1];
        nodes = new Node[N*N + 1];
        visit = new boolean[N][N];
        List<Integer> students = new ArrayList<>();
        for(int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = parseInt(st.nextToken());
            nodes[student] = new Node(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()));
            students.add(student);
        }
        for(int student : students) {
            List<Location> firstRuleLocations = checkFirstRule(nodes[student]);
            if(firstRuleLocations.size() > 1) {
                List<Location> secondRuleLocations = checkSecondRule(firstRuleLocations);
                if(secondRuleLocations.size() > 1) {
                    Location thirdRuleLocation = checkThirdRule(secondRuleLocations);
                    setLocation(student, thirdRuleLocation);
                } else {
                    Location location = secondRuleLocations.get(0);
                    setLocation(student, location);
                }
            } else {
                Location location = firstRuleLocations.get(0);
                setLocation(student, location);
            }
        }
        System.out.println(getTotalScore());
    }

    public static void setLocation(int i, Location location) {
        visit[location.x][location.y] = true;
        locations[i] = location;
    }
    public static int getTotalScore() {
        int answer = 0;
        for(int i = 1; i < N * N + 1; i++) {
            int count = 0;
            Location location = locations[i];
            for(int friend : nodes[i].friends) {
                Location friendLocation = locations[friend];
                if(location.isNear(friendLocation)) {
                    count++;
                }
            }
            answer += satisfaction[count];
        }
        return answer;
    }

    public static Location checkThirdRule(List<Location> secondRuleLocations) {
        Collections.sort(secondRuleLocations);
        return secondRuleLocations.get(0);
    }
    public static List<Location> checkSecondRule(List<Location> firstRuleLocations) {
        List<Location> answers = new ArrayList<>();
        int count = 0;
        Map<Location, Integer> locationCount = new HashMap<>();
        for(Location location : firstRuleLocations) {
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + location.x;
                int dy = directY[i] + location.y;
                if(dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dx][dy]) {
                    continue;
                }
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }
        }
        for(Location location : firstRuleLocations) {
            if(count == locationCount.getOrDefault(location, 0)) {
                answers.add(location);
            } else if(count < locationCount.getOrDefault(location, 0)) {
                count = locationCount.get(location);
                answers = new ArrayList<>();
                answers.add(location);
            }
        }
        return answers;
    }
    public static List<Location> checkFirstRule(Node node) {
        Map<Location, Integer> locationCount = new HashMap<>();
        int count = 0;
        List<Location> answer = new ArrayList<>();
        for(int friend : node.friends) {
            if(locations[friend] == null) {
                continue;
            }
            List<Location> nearLocations = getNearLocation(locations[friend]);
            for(Location location : nearLocations) {
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }
            for(Location location : nearLocations) {
                if(count < locationCount.getOrDefault(location,0)) {
                    count = locationCount.get(location);
                    answer = new ArrayList<>();
                    answer.add(location);
                } else if(count == locationCount.getOrDefault(location, 0)) {
                    answer.add(location);
                }
            }
        }
        if(answer.isEmpty()) {
            answer = getNoFriendLocation();
        }
        return answer;
    }

    public static List<Location> getNoFriendLocation() {
        List<Location> answer = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]){
                    continue;
                }
                answer.add(new Location(i, j));
            }
        }
        return answer;
    }
    public static List<Location> getNearLocation(Location friend) {
        List<Location> nearLocations = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int dx = friend.x + directX[i];
            int dy = friend.y + directY[i];
            if(dx >= N || dy >= N || dx < 0 || dy < 0 || visit[dx][dy]) {
                continue;
            }
            nearLocations.add(new Location(dx, dy));
        }
        return nearLocations;
    }
}
