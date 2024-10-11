// 순회
// left + right == 0 되는 애 찾기
// 이전 애랑 똑같은 애 지나치기
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    answers.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answers;
    }
}