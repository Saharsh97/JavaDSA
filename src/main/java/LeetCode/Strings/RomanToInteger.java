package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int solve(String str){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = str.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c == 'V' || c == 'L' || c == 'D' || c == 'M'){
                sum += map.get(c);
            } else {
                if(i == n-1){
                    sum += map.get(c);
                    return sum;
                }
                char nextC = str.charAt(i+1);
                if(c=='I' && (nextC == 'V' || nextC == 'X')){
                    sum += map.get(nextC) - map.get(c);
                    i++;
                }
                else if(c=='X' && (nextC == 'L' || nextC == 'C')){
                    sum += map.get(nextC) - map.get(c);
                    i++;
                }
                else if(c=='C' && (nextC == 'D' || nextC == 'M')){
                    sum += map.get(nextC) - map.get(c);
                    i++;
                } else {
                    sum += map.get(c);
                }
            }
        }
        return sum;
    }
}

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.