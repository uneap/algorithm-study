// 한차례 순회하면서 length와 같거나 넘길 수 있을 때 return
class Solution {
    public int jump(int[] nums) {
        int jump = nums[0];
        int maxJump = nums[0];
        int answer = 1;
        if(nums.length == 1) {
            return 0;
        }
        for(int i = 1; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if(i == jump) {
                jump = maxJump;
                answer++;
            }
        }
        return answer;
    }
}