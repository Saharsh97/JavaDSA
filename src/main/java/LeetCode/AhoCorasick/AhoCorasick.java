package LeetCode.AhoCorasick;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AhoCorasick {
    class TrieNode{
        Character character;
        Map<Character, TrieNode> children;
        TrieNode suffixLink;
        TrieNode outputLink;
        int wordIndex;

        TrieNode(Character character) {
            this.character = character;
            this.children = new HashMap<>();
            this.suffixLink = null;
            this.outputLink = null;
            this.wordIndex = -1;
        }
    }

    public void generateTrie(TrieNode root, String[] patterns){
        for(int i = 0; i < patterns.length; i++) {
            // add this word to Trie.
            TrieNode current = root;
            for (Character c : patterns[i].toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode(c));
                }
                current = current.children.get(c);
            }
            current.wordIndex = i;
        }
    }

    public void generateSuffixLinksAndOutputLinks(TrieNode root){
        root.suffixLink = root;
        Queue<TrieNode> bfsQueue = new LinkedList<>(); // for BFS Traversal

        for(Character character: root.children.keySet()){
            root.children.get(character).suffixLink = root;
            bfsQueue.add(root.children.get(character));
        }

        while(!bfsQueue.isEmpty()){
            TrieNode currentNode = bfsQueue.poll();

            // setting suffix link
            for(Character character: currentNode.children.keySet()){
                TrieNode childNode = currentNode.children.get(character);
                TrieNode parentSuffixLink = currentNode.suffixLink; // for this child node, its parent suffixlink. // parentSuffixLink = root for depth 1.

                while(!parentSuffixLink.children.containsKey(character) && parentSuffixLink != root){
                    parentSuffixLink = parentSuffixLink.suffixLink;
                }

                if(parentSuffixLink.children.containsKey(character)){
                    childNode.suffixLink = parentSuffixLink.children.get(character);
                } else {
                    childNode.suffixLink = root;
                }
                bfsQueue.add(childNode);
            }


            // setting output link
            if(currentNode.suffixLink.wordIndex >= 0){
                currentNode.outputLink = currentNode.suffixLink;
            } else {
                currentNode.outputLink = currentNode.suffixLink.outputLink;
            }
        }
    }


}
