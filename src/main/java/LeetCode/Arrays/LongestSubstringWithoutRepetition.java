package LeetCode.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        Deque<Character> word = new ArrayDeque<>();
        int maxLength = 0;
        for(Character c: s.toCharArray()){
            if(freq[c] != 0){
                while(freq[c] != 0){
                    Character firstC = word.pop();
                    freq[firstC]--;
                }
            }
            word.add(c);
            maxLength = Math.max(maxLength, word.size());
            freq[c]++;
        }
        return maxLength;
    }
}
