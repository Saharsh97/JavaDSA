package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

    Map<Integer, String> map = new HashMap<>();

    public String countAndSay(int n) {
        if(map.isEmpty()) preCompute();
        return map.get(n);
    }

    private void preCompute(){
        String result = "1";
        map.put(1, result);
        for(int i = 2; i <= 30; i++){
            StringBuilder newResult = new StringBuilder("");
            char currentCharacter = result.charAt(0);
            int count = 1;
            for(int j = 1; j < result.length(); j++){
                if(result.charAt(j) == currentCharacter){
                    count++;
                } else {
                    newResult.append(String.valueOf(count) + currentCharacter);
                    currentCharacter = result.charAt(j);
                    count = 1;
                }
            }
            newResult.append(String.valueOf(count) + currentCharacter);
            result = newResult.toString();
            map.put(i, result);

        }
    }











//    Map<Integer, String> map = new HashMap<>();

//    public String countAndSay(int n) {
//        if(map.containsKey(n)) return map.get(n);
//
//        String result = "1";
//        for(int i = 2; i <= n; i++){
//            if(map.containsKey(i)){
//                result = map.get(i);
//                continue;
//            }
//            String newResult = "";
//            char currentCharacter = result.charAt(0);
//            int count = 1;
//            for(int j = 1; j < result.length(); j++){
//                if(result.charAt(j) == currentCharacter){
//                    count++;
//                } else {
//                    newResult += String.valueOf(count) + currentCharacter;
//                    currentCharacter = result.charAt(j);
//                    count = 1;
//                }
//            }
//            newResult += String.valueOf(count) + currentCharacter;
//            result = newResult;
//            map.putIfAbsent(i, result);
//        }
//        return result;
//    }
}
