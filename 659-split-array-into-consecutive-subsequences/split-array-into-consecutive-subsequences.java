//  연속적으로 이어지는 케이스
// 3개로만 끝나는 케이스로 나누어서 체크함
import java.util.*;
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numberAndCount = new HashMap<>();
        Map<Integer, Integer> possible = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numberAndCount.put(nums[i], numberAndCount.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(numberAndCount.getOrDefault(nums[i], 0) == 0) {
                continue;
            }
            if(possible.getOrDefault(nums[i], 0) > 0) {
                possible.put(nums[i], possible.get(nums[i]) - 1);
                possible.put(nums[i] + 1, possible.getOrDefault(nums[i] + 1, 0) + 1);
            } else if(numberAndCount.getOrDefault(nums[i] + 1, 0) > 0 
                      && numberAndCount.getOrDefault(nums[i] + 2, 0) > 0) {
                numberAndCount.put(nums[i] + 1, numberAndCount.getOrDefault(nums[i] + 1, 0) - 1);
                numberAndCount.put(nums[i] + 2, numberAndCount.getOrDefault(nums[i] + 2, 0) - 1);
                possible.put(nums[i] + 3, possible.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
            numberAndCount.put(nums[i], numberAndCount.getOrDefault(nums[i], 0) - 1);
        }
        return true;
    }
}