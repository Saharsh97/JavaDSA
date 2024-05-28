package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String pattern) {
        if(a == pattern) return 0;
        int n = a.length(); int m = pattern.length();
        StringBuilder str = new StringBuilder(a);
        int count = 0;
        while(n < m){
            str.append(a);
            n = str.length();
            count++;
        }
        if(str.toString().equals(pattern)) return count;
        if(rabinKarp(str.toString(), pattern)) return count;
        if(rabinKarp(str.append(a).toString(), pattern)) return count+1;
        return -1;
    }

    private boolean rabinKarp(String text, String pattern){
        StringBuilder window = new StringBuilder(text.substring(0, pattern.length()));
        Map<String, Integer> map = new HashMap<>();
        map.put(pattern, 1);

        if(map.containsKey(window.toString())) return true;
        for(int i = pattern.length(); i < text.length(); i++){
            window.append(text.charAt(i));
            window.delete(0, 1);
            if(map.containsKey(window.toString())) return true;
        }
        return false;
    }
}
