// 갈 수 없는 길이라면 0
// 0 x *  이거나 *x0 인 경우, 장애물 있으면 막혀있어서 0으로 채워야 함.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 1 || i > 0 && dp[i - 1][0] == 0) {
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = 1;
        }
        for(int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 1 || i > 0 && dp[0][i - 1] == 0) {
               dp[0][i] = 0;
                continue;
            }
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}