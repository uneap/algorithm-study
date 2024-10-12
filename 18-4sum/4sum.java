import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(nums, target, i, answers);
        }
        return answers;
    }
    
    public void threeSum(int[] nums, int target, int index, List<List<Integer>> answers) {
        for(int i = index + 1; i < nums.length; i++) {
            if(i > index + 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                long sum = (long)nums[left] + (long)nums[right] + (long)nums[i] + (long)nums[index];
                if(sum == target) {
                    answers.add(Arrays.asList(nums[index], nums[i], nums[left],nums[right]));
                    left ++;
                    right --;
                    while(left < right && nums[left - 1] == nums[left]) {
                        left ++;
                    }
                    while(left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }else if(sum < target) {
                    left++;                   
                } else {
                    right --;
                }
            }
        }
    }
}