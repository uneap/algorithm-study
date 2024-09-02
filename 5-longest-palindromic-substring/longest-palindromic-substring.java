class Solution {
    public int checkPalindrome(int[][] dp, int start, int end, String s) {
        if(dp[start][end] != 0) {
            return dp[start][end];
        }
        if(end - start + 1 <= 1) {
            dp[start][end] = 1;
        }
        else if(s.charAt(start) == s.charAt(end)) {
            dp[start][end] = checkPalindrome(dp, start + 1, end - 1, s);
        } else {
            dp[start][end] = -1;
        }
        return dp[start][end];
    }
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0, end = 1;
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(j - i + 1 > maxLength && checkPalindrome(dp, i, j, s) == 1) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}