package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            Character c = pattern.charAt(i);
            if(map1.containsKey(c) && !words[i].equals(map1.get(c))) return false;
            if(map2.containsKey(words[i]) && c != map2.get(words[i])) return false;
            map1.put(c, words[i]);
            map2.put(words[i], c);
        }
        return true;
    }
}
