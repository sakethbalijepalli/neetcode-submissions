class Solution {
    public int numIslands(char[][] grid) {
        // 1 represensts land and 0 represents water.
        int count = 0;
        int row = grid.length, col = grid[0].length;
        int[][] visit = new int[grid.length][grid[0].length];
        for(int r = 0;r < grid.length;r++){
            for(int c = 0;c < grid[0].length;c++){
                if(grid[r][c] == '1' && visit[r][c] == 0){
                    count++;
                    dfs(grid,row,col,r,c,visit);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col,int r,int c,int[][] visit){
        if (Math.min(r,c) < 0 || r >= row || c >= col || visit[r][c] == 1 || grid[r][c] == '0'){
            return;
        }
        visit[r][c] = 1;
        dfs(grid,row,col,r + 1,c,visit);
        dfs(grid,row,col,r - 1,c,visit);
        dfs(grid,row,col,r,c + 1,visit);
        dfs(grid,row,col,r ,c - 1,visit);

    }
}
