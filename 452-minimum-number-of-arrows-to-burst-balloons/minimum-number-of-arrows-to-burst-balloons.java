// 오른쪽 작은 순으로 정렬 pq로
// 순회하면서, 오른쪽으로 겹칠 수 있는 애들 모조리 삭제
// 순회 할 때마다 count세기
import java.util.*;
class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point point) {
           if((long)this.y - (long)point.y < 0) {
               return -1;
           } else if((long)this.y - (long)point.y == 0) {
               return 0;
           } else {
               return 1;
           }
        }
        
        public boolean overlap(Point point) {
            return this.y >= point.x;
        }
    }
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i < points.length; i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
        }
        int answer = 0;
        while(!pq.isEmpty()) {
            answer++;
            Point point = pq.poll();
            while(!pq.isEmpty() && point.overlap(pq.peek())) {
                pq.poll();
            }
        }
        return answer;
    }
}