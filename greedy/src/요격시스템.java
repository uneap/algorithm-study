// 정렬
// right range로 지워나감
import java.util.*;
class Solution {
    class Range implements Comparable<Range> {
        int left;
        int right;
        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo(Range range) {
            return this.right - range.right;
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Range> pq = new PriorityQueue<>();
        for(int i = 0;i < targets.length; i++) {
            pq.offer(new Range(targets[i][0], targets[i][1]));
        }
        while(!pq.isEmpty()) {
            Range range = pq.poll();
            while(!pq.isEmpty() && range.right -1 <= pq.peek().right && range.right-1 >= pq.peek().left) {
                pq.poll();
            }
            answer++;
        }
        return answer;
    }
}