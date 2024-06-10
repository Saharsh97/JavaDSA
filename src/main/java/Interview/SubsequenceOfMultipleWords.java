package Interview;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SubsequenceOfMultipleWords {

    /*
     * Complete the 'getValidWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING_ARRAY dictionary
     */



    public static String getValidWord(String s, List<String> dictionary){
        int n = s.length();
        String answer = "";
        for(String word: dictionary){
            if(isSubsequence(word, s)){
                if(answer.isEmpty()){
                    answer = word;
                } else {
                    answer = compareWords(answer, word);
                }
            }
        }
        return answer.isEmpty() ? "-1" : answer;
    }

    private static String compareWords(String word, String text){
        int p = 0;
        int q = 0;
        while(p < word.length() && q < text.length()){
            if(word.charAt(p) < text.charAt(q)) return word;
            if(word.charAt(p) > text.charAt(q)) return text;
            p++;
            q++;
        }

        if(word.length() < text.length()) return word;
        return text;
    }

    private static boolean isSubsequence(String word, String text){
        int n = text.length();
        int m = word.length();
        int q = 0;
        for(int p = 0; p < n; p++){
            if(text.charAt(p) == word.charAt(q)){
                q++;
            }
            if( q == m ){
                return true;
            }
        }
        return false;
    }

}

