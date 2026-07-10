class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOrangesCount = 0;
        for(int r = 0; r < grid.length;r++){
            for(int c = 0;c < grid[0].length;c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    freshOrangesCount++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshOrangesCount > 0){
            int len = queue.size();
            for(int i = 0;i < len;i++){
                int[] rottenCoordinate = queue.remove();
                int r = rottenCoordinate[0], c = rottenCoordinate[1];
                int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] neighbor : neighbors) {
                    int dr = neighbor[0], dc = neighbor[1];
                    if (Math.min(r + dr, c + dc) < 0 ||
                            r + dr == ROWS || c + dc == COLS || grid[r + dr][c + dc] == 0 || grid[r + dr][c + dc] == 2) {
                        continue;
                    }
                    grid[r + dr][c + dc] = 2;
                    freshOrangesCount--;
                    queue.add(new int[]{r + dr,c + dc});
                }
            }
            minutes++;
        }
    return freshOrangesCount == 0 ? minutes : -1;
    }
}
