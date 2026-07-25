class WordDictionary {
    TrieNode root; 
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(!curr.map.containsKey(c)){
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int j,TrieNode root){
        TrieNode curr = root;

        for(int i = j;i < word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode node : curr.map.values()){
                    if(node != null && dfs(word,i + 1,node)){
                        return true;
                    }
                    
                }     
                return false;
            }else{
                if(!curr.map.containsKey(c)){
                    return false;   
                } 
                curr = curr.map.get(c);
            }    
        }
        return curr.word;
    }
}

class TrieNode {

    public HashMap<Character,TrieNode> map;
    public boolean word;

    public TrieNode(){
        map = new HashMap<>();
        word = false;
    }
}
