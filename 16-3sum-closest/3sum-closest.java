class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = 0;
        int interval = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1; int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < interval) {
                    answer = sum;
                    interval = Math.abs(sum - target);
                }
                if(sum < target) {
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return answer;
    }
}