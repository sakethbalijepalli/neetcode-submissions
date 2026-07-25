class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for (String word : words) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == word.charAt(0)) {
                        dfs(row, col, 0, board, word, res);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int row,int col,int j,char[][] board,String word,Set<String> res){
        if(row == board.length || col == board[0].length || Math.min(row,col) < 0 || board[row][col] == '1'){
            return;
        }
        if(word.charAt(j) != board[row][col]){
            return;
        }
        if(j == word.length() - 1){
            res.add(word);
            return;
        }

        char temp = board[row][col];
        board[row][col] = '1';
        dfs(row + 1,col,j + 1,board,word,res);
        dfs(row - 1,col,j + 1,board,word,res);
        dfs(row,col + 1,j + 1,board,word,res);
        dfs(row,col - 1,j + 1,board,word,res);
        board[row][col] = temp;
    }
}
