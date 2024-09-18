class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> answers = new HashSet<>();
        make(answers, new LinkedList<>(), nums, 0);
        return new ArrayList<>(answers);
    }
    
    public void make(Set<List<Integer>> answers, LinkedList<Integer> answer, int[] nums, int i) {
        if(answer.size() > nums.length) {
            return;
        }
        answers.add(new ArrayList<>(answer));
        if(i >= nums.length) {
            return;
        }
        answer.add(nums[i]);
        make(answers, answer, nums, i + 1);
        answer.removeLast();
        make(answers, answer, nums, i + 1);
    }
}