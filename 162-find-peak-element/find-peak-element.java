class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0; int right = nums.length -1;
        if(nums.length == 1) {
            return 0;
        }
        while(left < right) {
            int mid = (left + right) / 2;
            if(mid - 1 < 0 || mid + 1 >= nums.length) {
                if(nums[left] > nums[right]) {
                    return left;
                } else {
                    return right;
                }
            } 
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if(nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
}