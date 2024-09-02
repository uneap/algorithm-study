// 하나씩 제거하면서 팰린드롬 확인
class Solution {
    public String longestPalindrome(String s) {
        for(int i = s.length(); i >= 0; i --) {
            for(int j = 0; j + i <= s.length(); j++) {
                String str = s.substring(j, i + j);
                boolean isPalindrome = true;
                for(int k = 0; k < i / 2; k++) {
                    if(str.charAt(k) != str.charAt(str.length() - 1 - k)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPalindrome) {
                    return str;
                }
            }
        }
        return s.substring(0,1);
    }
}