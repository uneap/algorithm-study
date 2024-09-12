class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        Arrays.fill(range, -1);
        int left = 0; int right = nums.length - 1;
        if(nums.length == 0) {
            return new int[]{-1,-1};
        }
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                if(range[0] == - 1) {
                    range[0] = mid;
                    range[1] = mid;
                }
                while(++mid < nums.length && nums[mid] == target){
                    range[1] = mid;
                }
                while(--mid >= 0 && nums[mid] == target){
                    range[0] = mid;
                }
                return range;
            }
            if(nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return nums[left] == target ? new int[]{left, left} : range;
    }
}