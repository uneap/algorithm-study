class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        if(nums.length == 1) {
            return true;
        }
        for(int i = 0; i < nums.length; i++) {
            if(maxJump < i) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
            if(maxJump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}