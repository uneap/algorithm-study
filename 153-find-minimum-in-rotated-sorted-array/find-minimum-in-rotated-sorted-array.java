// right가 mid보다 큰 경우, right = mid 
// 큰 경우, left = mid + 1
class Solution {
    public int findMin(int[] nums) {
        int left = 0; int right = nums.length - 1;
        int answer = Integer.MAX_VALUE;
        while(left < right) {
            int mid = (left + right) / 2;
            answer = Math.min(answer, nums[mid]);
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(answer, nums[left]);
    }
}