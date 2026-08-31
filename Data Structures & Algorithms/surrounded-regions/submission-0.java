class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][n - 1] == 'O') dfs(board, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[m - 1][c] == 'O') dfs(board, m - 1, c);
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != 'O'){
            return;
        }
        board[r][c] = '#';
        dfs(board,r + 1, c);
        dfs(board,r - 1, c);
        dfs(board,r, c + 1);
        dfs(board,r, c - 1);
    }
}
