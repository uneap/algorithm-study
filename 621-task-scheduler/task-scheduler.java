// 가장 최대 빈도로 나오는 알파벳에서 빈 부분 찾기
// 그 빈부분 채워줄 수 있는 애 채워주고, 남은 애 더하기
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxCount = 0;
        int maxIndex = 0;
        int[] frequency = new int[27];
        for(int i = 0; i < tasks.length; i++) {
            frequency[tasks[i] - 'A'] ++;
            if(frequency[tasks[i] - 'A'] > maxCount) {
                maxCount = frequency[tasks[i] - 'A'];
                maxIndex = tasks[i] - 'A';
            }
        }
        int idle = (maxCount - 1) * n;
        for(int i = 0; i <= 26; i++) {
            if(i == maxIndex) {
                continue;
            }
            idle -= Math.min(maxCount - 1, frequency[i]);
        }
        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}