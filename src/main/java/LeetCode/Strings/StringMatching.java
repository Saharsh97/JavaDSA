package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringMatching {
    public int strStr(String haystack, String needle) {
        Map<String, Boolean> map = new HashMap<>();
        map.put(needle, true);

        StringBuilder word = new StringBuilder();
        for(int i = 0; i < haystack.length(); i++){
            word.append(haystack.charAt(i));
            if(word.length() < needle.length()){
                continue;
            }
            if(word.length() > needle.length()){
                word.delete(0, 1);
            }
            if(map.containsKey(word.toString())){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}
