// 오름차순으로 정렬해야하므로, 왼쪽부터는 가장 큰 값을 오른쪽부터는 가장 작은 값으로 체크해서 범위 체크
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -2; int right = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[nums.length - 1 - i], min);
            if(max > nums[i]) {
                left = i;
            }
            if(min < nums[nums.length - 1 - i]) {
                right = nums.length - 1 - i;
            }
        }
        return left - right + 1;
    }
}