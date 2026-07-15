class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 0 0 0
        // 0 0 0
        // 0 1 0
        return dfsTopDown(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,new int[obstacleGrid.length][obstacleGrid[0].length]);
    }

    private int dfsTopDown(int r,int c,int ROW,int COL,int[][] obstacleGrid,int[][] memoization){
        if(r == ROW || c == COL || obstacleGrid[r][c] == 1){
            return 0;
        }
        if(memoization[r][c] > 1){
            return memoization[r][c];
        }
        if(r == ROW - 1 && c == COL - 1){
            return 1;
        }
        memoization[r][c] = dfsTopDown(r + 1,c,ROW,COL,obstacleGrid,memoization) + dfsTopDown(r, c + 1,ROW,COL,obstacleGrid,memoization);
        return memoization[r][c];
    }
}