class Solution {
    public int findDuplicate(int[] nums) {
        int left = nums[0], right = nums[0];
        do {
            left = nums[nums[left]];
            right = nums[right];
        }while(left != right);
        left = nums[0];
        while(left != right){
            left = nums[left];
            right = nums[right];
        }
        return left;
    }
}