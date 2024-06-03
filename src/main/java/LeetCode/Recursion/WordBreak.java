package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBreak {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word: dictionary) map.put(word, 1);

        recur(0, s, "", map, result);
        return result;
    }

    private static void recur(int st, String str, String path, Map<String, Integer> map, ArrayList<String> result){
        if(st >= str.length()){
            result.add(path.substring(0, path.length()-1));
        }
        String word = "";
        for(int i = st; i < str.length(); i++){
            word += str.charAt(i);
            if(map.containsKey(word)){
                recur(i+1, str, path + word + " ", map, result);
            }
        }
    }
}
