class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> keyAndCount = new HashMap<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String key = s.substring(i, i + 10);
            keyAndCount.put(key, keyAndCount.getOrDefault(key, 0) + 1);
        }
        List<String> answers = new ArrayList<>();
        for(String key : keyAndCount.keySet()) {
            if(keyAndCount.get(key) > 1){
            answers.add(key);
            }
        }
        return answers;
    }
}