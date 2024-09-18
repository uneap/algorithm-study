class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();
        Arrays.sort(nums);
        combination(answers, new LinkedList<>(), 0, nums);
        return new ArrayList<>(answers);
    }
    public void combination(Set<List<Integer>> answers, LinkedList<Integer> answer, int i,int[] nums) {
        answers.add(new ArrayList<>(answer));
        if(i >= nums.length) {
            return;
        }
        for(int index = i; index < nums.length; index++) {
            answer.add(nums[index]);
            combination(answers, answer, index + 1, nums);
            answer.removeLast();
        }
    }
}