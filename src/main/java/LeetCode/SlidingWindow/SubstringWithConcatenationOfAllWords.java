package LeetCode.SlidingWindow;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int totalLength = words.length * words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        List<Integer> str = new ArrayList<>();
        for(int i = 0; i < s.length();){
            String subWord = i + words[0].length() <= s.length() ? s.substring(i, i + words[0].length()) : s.substring(i);
            if(map.containsKey(subWord)) {
                str.add(map.get(subWord));
                i += words[0].length();
            } else {
                str.add(-i);
                i++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int lastNegativeIndex = -1;
        for(int i = 0; i < str.size(); i++) {
            int newInt = str.get(i);
            if(newInt < 0){
                lastNegativeIndex = -newInt;
                set = new HashSet<>();
                deque = new ArrayDeque<>();
                continue;
            }
            if (!set.contains(newInt)) {
                set.add(newInt);
                deque.add(newInt);
                if (set.size() == words.length) {
                    result.add(lastNegativeIndex + 1);
                }
            } else {
                while(!set.isEmpty() && set.contains(newInt)){
                    set.remove(deque.pollFirst());
                }
            }
        }
        return result;
    }
}
