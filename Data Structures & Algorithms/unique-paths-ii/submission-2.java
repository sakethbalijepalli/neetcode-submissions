class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 0 0 0
        // 0 0 0
        // 0 1 0
        return bottomUpDfs(obstacleGrid.length,obstacleGrid[0].length,obstacleGrid);
    }

   private int bottomUpDfs(int r,int c,int[][] obstacleGrid){
        int[] dp = new int[c];
        if (obstacleGrid[r - 1][c - 1] == 0) {
            dp[c - 1] = 1;
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j + 1 < c) {
                        dp[j] = dp[j] + dp[j + 1];
                    }
                }
            }
        }
        return dp[0];
    }
}