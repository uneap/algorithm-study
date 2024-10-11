/// array를 end가 가장 작은 거, end가 같으면 end와 start의 차가 가장 작은 순으로 정렬
// 순회하면서 stack에 집어넣음, stack.peek()했을 때 현재랑 겹치면 stack에 안넣음.
// array size - stack.size 리턴
import java.util.*;
class Solution {
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public boolean overlap(int[] interval) {
            return (this.start >= interval[0] && this.end <= interval[1]) ||
                (this.start <= interval[0] && this.end > interval[0]);
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
            return a[1] - b[1];
        });
        Stack<Interval> stack = new Stack<>();
        for(int i = 0; i < intervals.length; i++) {
            if(stack.isEmpty() || (!stack.isEmpty() && !stack.peek().overlap(intervals[i]))) {
                stack.push(new Interval(intervals[i][0], intervals[i][1]));
            }
        }
        return intervals.length - stack.size();
    }
}