package LeetCode.Trie;

public class TrieSolution {

    public String AllPossibleStrings(int n, String[] words) {
        TrieNode root = new TrieNode('.');
        for(String word: words) {
            generateTrie(root, word);
        }

        String result = "";
        for(String word: words) {
            if(checkCompletePrefix(root, word) && word.length() > result.length())
                result = word;
        }
        return result;
    }

    private void generateTrie(TrieNode root, String word) {
        TrieNode temp = root;
        for (Character c : word.toCharArray()) {
            if (temp.children[c] == null) {
                temp.children[c] = new TrieNode(c);
            }
            temp = temp.children[c];
        }
        temp.isLeafNode = true;
    }

    public boolean checkCompletePrefix(TrieNode root, String word){
        TrieNode temp = root;
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
}