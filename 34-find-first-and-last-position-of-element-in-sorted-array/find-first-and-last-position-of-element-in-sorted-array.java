class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = findFirst(nums, target);
        answer[1] = findLast(nums, target);
        return answer;
    }
    public int findLast(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
    public int findFirst(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}