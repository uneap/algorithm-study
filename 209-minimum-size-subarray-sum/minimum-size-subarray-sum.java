// 계속 순회하면서 더하기
// 더하다가 target보다 커지면 커진 게 유지될 때까지 첫번째 인덱스에서 빼줌.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int index = 0;
        int minusIndex = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while(index < nums.length) {
            sum += nums[index++];
            while(target <= sum && minusIndex < nums.length) {
                sum -= nums[minusIndex++];
                answer = Math.min(answer, index - minusIndex + 1);
            }    
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}