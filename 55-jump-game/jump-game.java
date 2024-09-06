class Solution {
    // 순회
    // 갈수 있는지 여부를 dp에 저장
    // 갈수 있으면 true 후 break
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        if(nums[0] != 0 || nums.length == 1) {
            dp[0] = true;
        }
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}