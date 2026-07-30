class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, heights[0][c], heights, ROWS, COLS, pacific);
            dfs(ROWS - 1, c, heights[ROWS - 1][c], heights, ROWS, COLS, atlantic);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights[r][0], heights, ROWS, COLS, pacific);
            dfs(r, COLS - 1, heights[r][COLS - 1], heights, ROWS, COLS, atlantic);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r,int c,int prevHeight,int[][] heights,int ROWS,int COLS,boolean[][] ocean){
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        ocean[r][c] = true;

        dfs(r + 1,c,heights[r][c],heights,ROWS,COLS,ocean);
        dfs(r - 1,c,heights[r][c] ,heights,ROWS,COLS,ocean);
        dfs(r,c + 1,heights[r][c],heights,ROWS,COLS,ocean);
        dfs(r,c - 1,heights[r][c],heights,ROWS,COLS,ocean);
    }
}
