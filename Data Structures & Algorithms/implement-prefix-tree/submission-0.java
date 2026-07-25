class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
         TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(!curr.map.containsKey(c)){
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
         TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            if(!curr.map.containsKey(c)){
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
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
