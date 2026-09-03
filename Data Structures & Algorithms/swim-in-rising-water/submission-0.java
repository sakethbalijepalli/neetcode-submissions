class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0] = true;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0], r = curr[1], c = curr[2];

            if(r == ROWS - 1 && c == COLS - 1){
                return currTime;
            }

            int[][] neighbors = new int[][]{{-1, 0},{1,0},{0,-1},{0,1}};

            for (int[] neighbor : neighbors) {
                int dr = neighbor[0], dc = neighbor[1];
                if (Math.min(r + dr, c + dc) < 0 ||
                        r + dr == ROWS || c + dc == COLS ||
                        visited[r + dr][c + dc]) {
                    continue;
                }
                int nextTime = Math.max(currTime,grid[r + dr][c + dc]);
                visited[r + dr][c + dc] = true;
                pq.add(new int[]{nextTime,r + dr, c + dc});
            }
        }
        return -1;
    }
}
