class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1; int right = 0;

        for(int i = 0; i < diffs.length; i++) {
            right = Math.max(diffs[i], right);
        }
        while(left < right) {
            int mid = (left + right) / 2;
            long time = 0;
            int presentTime = 0;
            for(int i = 0; i < diffs.length; i++) {
                if(diffs[i] <= mid) {
                    time += times[i];
                } else {
                    time += (diffs[i] - mid) * (presentTime + times[i]) + times[i];
                }
                presentTime = times[i];
            }
            if(time > limit) {
                left = mid + 1;
            } else if(time <= limit) {
                answer = mid;
                right = mid - 1;
            }
        }
        if(check(left, diffs, times, limit)) {
            return left;
        }
        return answer;
    }

    public boolean check(int mid, int[] diffs, int[] times, long limit) {
        long time = 0;
        int presentTime = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= mid) {
                time += times[i];
            } else {
                time += (diffs[i] - mid) * (presentTime + times[i]) + times[i];
            }
            presentTime = times[i];
        }
        return limit >= time;
    }
}