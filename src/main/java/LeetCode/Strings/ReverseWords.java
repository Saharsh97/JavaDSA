package LeetCode.Strings;

import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder(s);
        int idx = 0;
        while(str.charAt(idx) == ' ') idx++;
        str = new StringBuilder(str.substring(idx));
        idx = str.length()-1;
        while(str.charAt(idx) == ' ') idx--;
        str = new StringBuilder(str.substring(0, idx+1));

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            Character ch = str.charAt(i);
            stack.push(ch);
            if(ch == ' '){
                int j = i;
                while(j < str.length() && str.charAt(j) == ' ') j++;
                j--;
                i = j;
            }
        }

        StringBuilder result = new StringBuilder();
        StringBuilder oneWord = new StringBuilder();
        while(!stack.isEmpty()){
            Character ch = stack.pop();
            if(ch == ' '){
                result.append(oneWord);
                result.append(' ');
                oneWord = new StringBuilder();
            }
            else
                oneWord.insert(0, ch);
        }
        result.append(oneWord);
        return result.toString();
    }
}
