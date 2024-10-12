class Solution {
    public int triangleNumber(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    answer += right - left;
                    right --;
                }else {
                    left++;
                }
            }
        }
        return answer;
    }
}