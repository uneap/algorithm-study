import java.util.*;
// x보다 y가 변하는 이동 먼저
// key(x,y), value List<> time, Index
class Solution {
    class Visit {
        int time;
        int x;
        int y;
        Visit(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
        Visit(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Visit(Visit visit, int time) {
            this.x = visit.x;
            this.y = visit.y;
            this.time = time;
        }
        public Visit getDiff(Visit visit) {
            return new Visit(visit.x - x, visit.y - y);
        }
        @Override
        public int hashCode() {
            return Objects.hash(time,x,y);
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Visit) {
                Visit visit = (Visit)o;
                return this.time == visit.time && this.x == visit.x && this.y == visit.y;
            }
            return false;
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Visit, Set<Integer>> spaces = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            search(spaces, new Visit(points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]), i, routes, points);
        }
        for(Visit visit : spaces.keySet()) {
            if(spaces.get(visit).size() > 1) {
                answer++;
            }
        }
        return answer;
    }
    public void search(Map<Visit, Set<Integer>> spaces, Visit point, int index, int[][] routes, int[][] points) {
        Queue<Visit> q = new LinkedList<>();
        int time = 0;
        q.offer(new Visit(point, point.time));
        for(int i = 1; i < routes[0].length; i++){
            Visit endPoint = new Visit(points[routes[index][i] - 1][0], points[routes[index][i] - 1][1]);
            Visit diff = point.getDiff(endPoint);
            while(diff.x != 0) {
                time++;
                if(diff.x > 0) {
                    point.x++;
                    diff.x--;
                    q.offer(new Visit(point, time));
                } else {
                    point.x--;
                    diff.x++;
                    q.offer(new Visit(point, time));
                }
            }
            while(diff.y != 0) {
                time++;
                if(diff.y > 0) {
                    point.y++;
                    diff.y--;
                    q.offer(new Visit(point, time));
                } else {
                    point.y--;
                    diff.y++;
                    q.offer(new Visit(point, time));
                }
            }
        }
        while(!q.isEmpty()) {
            Visit visit = q.poll();
            Set<Integer> indexes = spaces.getOrDefault(visit, new HashSet<>());
            indexes.add(index);
            spaces.put(visit, indexes);
        }
    }
}