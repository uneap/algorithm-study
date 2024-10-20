
class Solution {
    public boolean checkValidString(String s) {
        int open = 0, close = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
                close++;
            } else if(s.charAt(i) == '*') {
                if(close > 0) {
                    close--;
                }
                open++;
            } else {
                open--;
                if(close > 0) {
                    close--;
                }
            }
            if(open < 0) {
                return false;
            }
        }
        return close == 0;
    }
}