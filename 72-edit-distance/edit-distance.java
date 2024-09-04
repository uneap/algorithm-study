// 01234 012
// horse ros
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        //string이 빈 값이 되게 하려면 delete하는데 되는 연산
        for(int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        //빈 값에서 i가 되게 하려면 insert하는데 되는 연산
        for(int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    //replace, delete, insert
                }
                
            }
        }
        return dp[n][m];
    }
}