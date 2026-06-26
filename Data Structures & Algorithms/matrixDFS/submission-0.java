class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid,0,0,new int[grid.length][grid[0].length]);
    }

    public int dfs(int[][] grid, int row, int col, int[][] visit){
        int ROW = grid.length, COL = grid[0].length;

        if(Math.min(row,col) < 0 || row == ROW || col == COL || visit[row][col] == 1  || grid[row][col] == 1){
            return 0;
        }
        if(row == ROW - 1 && col == COL - 1){
            return 1;
        }
        int count = 0;
        visit[row][col] = 1;
        count += dfs(grid,row + 1,col,visit);
        count += dfs(grid,row - 1,col,visit);
        count += dfs(grid,row,col + 1,visit);
        count += dfs(grid,row,col - 1,visit);
        visit[row][col] = 0;
        return count;
    }
}
