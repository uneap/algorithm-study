class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answers = new int[2];
        answers[0] = findFirst(nums, target);
        answers[1] = findLast(nums, target);
        return answers;
    }
    public int findLast(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) { // 가장 인덱스가 큰 경우를 찾을 것임
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
        while(left <= right) { // 가장 인덱스가 작을 것을 찾을 것임
            int mid = (left + right)/ 2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            
        }
        return index;
    }
}