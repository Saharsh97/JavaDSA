package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String str, int numRows) {
        if(numRows == 1) return str;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int k = 0;
        int mode = 1;
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            rows[k].append(c);

            if(k == numRows - 1) mode = -1;
            if(k == 0) mode = 1;
            k += mode;
        }

        StringBuilder answer = new StringBuilder();
        for(StringBuilder word: rows){
            answer.append(word);
        }
        return answer.toString();
    }
}
