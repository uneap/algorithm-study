class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        make(answers, new LinkedList<>(), nums, 0);
        return new ArrayList<>(answers);
    }
    
    public void make(List<List<Integer>> answers, LinkedList<Integer> answer, int[] nums, int i) {
        answers.add(new ArrayList<>(answer));
        for(int index = i; index < nums.length; index++){
            answer.add(nums[index]);
            make(answers, answer, nums, index + 1);
            answer.removeLast();
        }
        
    }
}