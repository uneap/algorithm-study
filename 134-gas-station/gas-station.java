// 1, 2, 3, 4, 5
// 3, 4, 5, 1, 2
// -2 -2 -2 3 3
// 순회하면서 합계를 구함
// 양수가 되는 지점이 station 첫 구간이 될 수 있고, 총합이 0보다 크거나 같아야 한다.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int answer = -1;
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] - cost[i] >= 0 && answer == -1) {
                answer = i;
                sum = gas[i] - cost[i];
            } else if(sum + gas[i] - cost[i] >= 0) {
                sum += gas[i] - cost[i];
            } else {
                answer = -1;
            }
            total += gas[i] - cost[i];
        }
        if(total >= 0 && sum >= 0) {
            return answer;
        }
        return -1;
    }
}