// 반복되는 알파벳의 크기를 먼저 정해야 함,
// A _ _ A
// 전체 길이를 정하고
// 사이사이에 알파벳을 끼워넣는 형태로 유휴 상태 길이를 정할 수 있다
// 가장 알파벳이 많은 애를 기준으로 전체 길이를 정한다
// 유휴 상태 길이를 측정하기 위해서, 사이사이에 다른 알파벳을 끼워넣는다
import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> alphabets = new HashMap<>();
        int maxAlphabetCount = 0;
        char alphabet = ' ';
        for(int i = 0; i < tasks.length; i++) {
            alphabets.put(tasks[i], alphabets.getOrDefault(tasks[i], 0) + 1);
            if(maxAlphabetCount < alphabets.get(tasks[i])){
                maxAlphabetCount = alphabets.get(tasks[i]);
                alphabet = tasks[i];
            }
        }
        int length = (maxAlphabetCount - 1) * n;
        for(char c : alphabets.keySet()) {
            if(alphabet == c) {
                continue;
            }
                length -= Math.min(maxAlphabetCount - 1, alphabets.get(c));
        }
        return length < 0 ? tasks.length : tasks.length + length;
    }
}