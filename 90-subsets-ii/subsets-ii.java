class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < 1 << nums.length; i++) {
            List<Integer> answer = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & 1 << j) != 0) {
                    answer.add(nums[j]);
                }
            }
            answers.add(answer);
        }
        return new ArrayList<>(answers);
    }
}