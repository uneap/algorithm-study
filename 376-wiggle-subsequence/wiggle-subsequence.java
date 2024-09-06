class Solution {
    public int wiggleMaxLength(int[] nums) {
        int answer = 1;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] == nums[j]) {
                    continue;
                }
                if(nums[i] > nums[j]) {
                    if(dp[j][0] % 2 == 0) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    } if(dp[j][1] % 2 == 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    }
                } else {
                    if(dp[j][1] % 2 == 0) {
                        dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    } if(dp[j][0] % 2 == 1) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                    }
                }
            }
            answer = Math.max(dp[i][0], Math.max(dp[i][1], answer));
        }
        return answer;
    }
}