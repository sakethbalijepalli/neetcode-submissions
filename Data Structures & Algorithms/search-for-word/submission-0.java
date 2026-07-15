class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    res = dfs(board,word,i,j,0);
                    if(res){
                        return res;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, String word,int i, int j,int wordIndex){
        if(wordIndex == word.length()){
            return true;
        }
        if(Math.min(i,j) < 0 || i == board.length || j == board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(wordIndex)){
            return false;
        }
        wordIndex+=1;
        char tempOriginalChar = board[i][j];
        board[i][j] = '#';
        boolean wordExists = dfs(board,word,i - 1,j,wordIndex) || dfs(board,word,i + 1,j,wordIndex) || dfs(board,word,i,j - 1,wordIndex) || dfs(board,word,i,j + 1,wordIndex);
        board[i][j] = tempOriginalChar;
        return wordExists;
    }
}
