class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsetSize = 1 << nums.length;
        List<List<Integer>> answers = new ArrayList<>();
        for(int i = 0; i < subsetSize; i++) {
            List<Integer> answer = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & 1 << j) != 0) {
                    answer.add(nums[j]);   
                }
            }
            answers.add(answer);
        }
        return answers;
    }
}