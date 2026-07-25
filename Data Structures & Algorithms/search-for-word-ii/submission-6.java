class Solution {
    private TrieNodeWord root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNodeWord();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            insert(root, word);
        }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    dfs(row, col, board, res,root);
                }
            }
        return res;
    }
    
    public void insert(TrieNodeWord root,String word){
        TrieNodeWord curr = root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNodeWord());
            }
            curr = curr.children.get(c);
        }
        curr.word = word;
    }

    private void dfs(int row,int col,char[][] board,List<String> res,TrieNodeWord root) {
      if (row == board.length || col == board[0].length || Math.min(row, col) < 0 || board[row][col] == '#') {
            return;
        }

        char c = board[row][col];

        if (!root.children.containsKey(c)) {
            return;
        }
        TrieNodeWord nextNode = root.children.get(c);
        if (nextNode.word != null) {
            res.add(nextNode.word);
            nextNode.word = null;
        }
        board[row][col] = '#';

        dfs(row + 1, col, board, res,nextNode);
        dfs(row - 1, col, board, res,nextNode);
        dfs(row, col + 1, board, res,nextNode);
        dfs(row, col - 1, board, res,nextNode);
        board[row][col] = c;
    }
}
class TrieNodeWord{
    HashMap<Character,TrieNodeWord> children;
    String word = null;

    public TrieNodeWord(){
        children = new HashMap<>();
    }
}
