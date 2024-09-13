// mid에서 right범위에 있느냐 left에서 Mid 범위에 있느냐
// right와 mid를 비교해야 범위선정이 가능함
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