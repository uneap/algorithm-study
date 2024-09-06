// 1~9인 케이스, 10~26인 케이스로 나눔
class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        if(s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            if(1 <= s.charAt(i - 1) - '0' && s.charAt(i - 1) - '0' <= 9) {
                dp[i] += dp[i - 1];
            }
            if(10 <= Integer.parseInt(s.substring(i-2, i)) &&  26 >= Integer.parseInt(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}