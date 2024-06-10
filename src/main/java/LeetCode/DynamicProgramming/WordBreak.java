package LeetCode.DynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
//    Recursion + caching
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Map<String, Boolean> map = new HashMap<>();
//        for(String word: wordDict) map.put(word, true);
//
//        Map<Integer, Boolean> cache = new HashMap<>();
//        cache.put(s.length(), true);
//        return recur(0, s, map, cache);
//    }
//
//    private boolean recur(int st, String str, Map<String, Boolean> map, Map<Integer, Boolean> cache){
//        if(cache.containsKey(st))  return cache.get(st);
//        if(st > str.length())   return false;
//
//        int n = str.length();
//        String word = "";
//        for(int i = st; i < n; i++){
//            word += str.charAt(i);
//            if(map.containsKey(word) && recur(st + word.length(), str, map, cache)){
//                return true;
//            }
//        }
//        cache.put(st, false);
//        return false;
//    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        for(String word: wordDict) map.put(word, true);

        Boolean[] dp = new Boolean[s.length()+1];   // on length, not index.
        dp[0] = true;    // length 0, true.

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){    // checks on intermediate j before i. if string from 0 to j is valid, and j+1 to i is valid.
                if(dp[j] != null && dp[j] && map.containsKey(s.substring(j, i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return map.containsKey(s) || dp[s.length()] != null ?  dp[s.length()] : false;
    }


//    class TrieNode{
//        Character character;
//        Map<Character, TrieNode> children;
//        boolean isWord;
//
//        public TrieNode(Character character){
//            this.character = character;
//            this.children = new HashMap<>();
//            this.isWord = false;
//        }
//    }
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        TrieNode root = new TrieNode('.');
//        for(String word: wordDict) addWordToTrie(word, root);
//
//        Map<Integer, Boolean> dp = new HashMap<>();
//        return recur(0, s, root, dp);
//    }
//
//    private boolean recur(Integer st, String text, TrieNode root, Map<Integer, Boolean> dp){
//        if(st == text.length()){
//            dp.put(st, true);
//            return true;
//        }
//        if(dp.containsKey(st)){
//            return dp.get(st);
//        }
//        TrieNode current = root;
//        for(int i = st; i < text.length(); i++){
//            Character character = text.charAt(i);
//            if(!current.children.containsKey(character)){
//                return false;
//            }
//            if(current.children.get(character).isWord){
//                if(recur(i+1, text, root, dp)){
//                    return true;
//                }
//            }
//            current = current.children.get(character);
//        }
//        dp.put(text.length(), current.isWord);
//        return current.isWord;
//    }
//
//    private void addWordToTrie(String word, TrieNode root){
//        TrieNode current = root;
//        for(Character character: word.toCharArray()){
//            if(!current.children.containsKey(character)){
//                current.children.put(character, new TrieNode(character));
//            }
//            current = current.children.get(character);
//        }
//        current.isWord = true;
//    }
}
