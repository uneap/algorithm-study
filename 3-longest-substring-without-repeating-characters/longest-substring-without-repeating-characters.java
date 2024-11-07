// set + 슬라이딩 윈도우
// 인덱스 2개로 설정
// 순회
// set에 알파벳 저장
// 알파벳 똑같은 거 안나올 때까지 end 인덱스 증가
// 알파벳 똑같은 거 있을 경우, 나올 때까지 start 증가시켜서 슬라이딩 윈도우 사이즈 감소
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, end = 0, maxLength = 0;
        Set<Character> uniqueChars = new HashSet<>();

        while (end < n) {
            if (!uniqueChars.contains(s.charAt(end))) {
                // 문자 추가하고 end 포인터 증가
                uniqueChars.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else {
                // 중복 문자 제거 후 start 포인터 증가
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }
}