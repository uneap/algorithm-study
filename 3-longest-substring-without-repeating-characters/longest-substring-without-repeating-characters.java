// set + 슬라이딩 윈도우
// 인덱스 2개로 설정
// 순회
// set에 알파벳 저장
// 알파벳 똑같은 거 안나올 때까지 end 인덱스 증가
// 알파벳 똑같은 거 있을 경우, 나올 때까지 start 증가시켜서 슬라이딩 윈도우 사이즈 감소
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int end = 0;
        int start = 0;
        int answer = 0;
        Set<Character> elements = new HashSet<>();
        while(s.length() > end) {
            char c = s.charAt(end);
            if(!elements.contains(c)) {
                elements.add(c);
                end++;
                answer = Math.max(answer, end - start);
            }else {
                elements.remove(s.charAt(start));
                start++;
            }
        }
        return answer;
    }
}