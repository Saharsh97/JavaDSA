package LeetCode.Trie;

public class TrieSolution {
    public String AllPossibleStrings(int n, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.generateTrie(word);
        }
        String result = "";
        for(String word: words) {
            if(checkCompletePrefix(trie, word) && word.length() > result.length())
                result = word;
        }
        return result;
    }

    public boolean checkCompletePrefix(Trie trie, String word){
        TrieNode temp = trie.root;
        for(Character c: word.toCharArray()){
            if(temp.children[c] == null){
                return false;
            }
            temp = temp.children[c];
            if(!temp.isLeafNode){
                return false;
            }
        }
        return true;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode('.');
        }

        public void generateTrie(String word) {
            TrieNode temp = root;
            for (Character c : word.toCharArray()) {
                if (temp.children[c] == null) {
                    temp.children[c] = new TrieNode(c);
                }
                temp = temp.children[c];
            }
            temp.isLeafNode = true;
        }
    }

    class TrieNode {
        Character character;
        TrieNode[] children = new TrieNode[256];
        boolean isLeafNode = false;

        TrieNode(Character c) {
            this.character = c;
        }
    }
}