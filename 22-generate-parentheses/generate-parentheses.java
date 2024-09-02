class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList<>();
        generate(n, n, "", answers);
        return answers;
    }
    public void generate(int left, int right, String answer, List<String> answers) {
        if(left == 0 && right == 0) {
            answers.add(answer);
        }
        if(right < left) {
            return;
        }
        if(left > 0){
            generate(left - 1, right, answer + "(", answers);
        }
        generate(left, right - 1, answer + ")", answers);
    }
}