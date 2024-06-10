package LeetCode.Trie;

public class TrieNode {
    Character character;
    TrieNode[] children = new TrieNode[256];
    boolean isLeafNode = false;

    TrieNode(Character c) {
        this.character = c;
    }
}