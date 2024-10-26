class Solution {
    public int findMin(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            answer = Math.min(nums[mid], answer);
            if(nums[right] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}