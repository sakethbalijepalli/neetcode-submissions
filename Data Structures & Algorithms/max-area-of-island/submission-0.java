class Solution {
     public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0; // Master tracking variable
        int row = grid.length, col = grid[0].length;
        int[][] visit = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1 && visit[r][c] == 0) {
                    int currentIslandArea = dfs(grid, row, col, r, c, visit);
                    maxArea = Math.max(maxArea, currentIslandArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int r, int c, int[][] visit) {
        if (r < 0 || c < 0 || r >= row || c >= col || visit[r][c] == 1 || grid[r][c] == 0) {
            return 0;
        }
        visit[r][c] = 1;
        return 1 + dfs(grid, row, col, r + 1, c, visit)
                + dfs(grid, row, col, r - 1, c, visit)
                + dfs(grid, row, col, r, c + 1, visit)
                + dfs(grid, row, col, r, c - 1, visit);
    }
}
