// 마지막 인덱스 저장
// 순회하면서, 가장 큰 마지막 인덱스 저장하고 이게 나올 때까지 계속 순회, 가장 큰 마지막 인덱스와 현재 순회위치가 동일하면 answer에 저장
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] alphas = new int['z' - 'a' + 1];
        for(int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i) - 'a'] = i;
        }
        int maxIndex = 0;
        int start = 0;
        List<Integer> answers = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(maxIndex < alphas[s.charAt(i) - 'a']) {
                maxIndex = alphas[s.charAt(i) - 'a'];
            } if(i == maxIndex) {
                answers.add(maxIndex - start + 1);
                start = i + 1;
            }
        }
        return answers;
    }
}