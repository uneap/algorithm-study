class Solution {
    // 순회
    // 다른 순회하는 인덱스는 중첩 인덱스 까지만 순회하면서 
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 10000);
        if(nums[0] != 0 || nums.length == 1) {
            dp[0] = 0;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j <= i + nums[i]; j++) {
                if(j >= nums.length) {
                    break;
                }
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1] < nums.length;
    }
}