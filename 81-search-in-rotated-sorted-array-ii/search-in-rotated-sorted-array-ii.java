// 로테이트 형태로 소팅되어있기 때문에 조건 나누고 영역 좁히는 게 중요
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return true;
            }
            if(nums[mid] >= nums[left]) {
                if(target < nums[mid] && target >= nums[left]) {
                   right--;
                } else {
                    left++;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return nums[left] == target;
    }
}