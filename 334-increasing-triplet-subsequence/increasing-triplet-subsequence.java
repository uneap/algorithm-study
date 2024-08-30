// i, j, k에 값을 넣어줌
// i 보다 더 작은 케이스 있으면 넣고
// i 보다 크면서 j보다 더 작은 케이스 있으면 갱신
// i 보다 크고 j 보다 큰 케이스 있으면 갱신
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, k = Integer.MIN_VALUE;
        for(int index= 0; index < nums.length; index++) {
            if(nums[index] < i) {
                i = nums[index];
            } else if(nums[index] > i && nums[index] < j) {
                j = nums[index];
            } else if(nums[index] > i && nums[index] > j) {
                k = nums[index];
            }
        }
        return i < j && j < k && i < k;
    }
}