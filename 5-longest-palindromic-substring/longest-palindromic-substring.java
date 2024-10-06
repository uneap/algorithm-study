// 맨 뒤부터 순회
// 인덱스 맨 앞부터 Palindrome 파악
class Solution {
    public String longestPalindrome(String s) {
        for(int i = s.length(); i >= 0; i--) {
            for(int j = 0; j + i <= s.length(); j++) {
                boolean palindrome = true;
                for(int k = 0; k < i / 2; k++) {
                    if(s.charAt(i + j - k - 1) != s.charAt(j + k)) {
                        palindrome = false;
                        break;
                    }
                }
                if(palindrome) {
                    return s.substring(j, i + j);
                }
            }
        }
        return s.charAt(0) + "";
    }
}