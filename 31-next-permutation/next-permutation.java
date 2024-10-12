// i - 1부터 순회하면서 i - 1 < i 있을 경우 next permutation 있음
// j 가 끝부터 i까지 순회, i - 1 < j  있으면 스왑
// i 부터 끝까지 복사해서 sort
class Solution {
    public void nextPermutation(int[] nums) {
        boolean next = false;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                next = true;
            }
            for(int j = nums.length - 1; j >= i; j--){
                if(next && nums[i - 1] < nums[j]) {
                    swap(nums, i - 1, j);
                    Arrays.sort(nums, i, nums.length);
                    return;
                }
            }
        }
        if(!next) {
            Arrays.sort(nums);
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}