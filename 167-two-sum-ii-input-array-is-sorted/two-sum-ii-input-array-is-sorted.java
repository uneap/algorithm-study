class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answers = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                answers[0] = left + 1;
                answers[1] = right + 1;
            }
            if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return answers;
    }
}