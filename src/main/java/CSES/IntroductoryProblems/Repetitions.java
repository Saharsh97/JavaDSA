package CSES.IntroductoryProblems;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        solve(str);
    }

    private static void solve(String str){
        int maxLen = 1;
        char currentCharacter = str.charAt(0);
        int currentCount = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == currentCharacter){
                currentCount++;
                maxLen = Math.max(maxLen, currentCount);
            } else {
                currentCharacter = str.charAt(i);
                currentCount = 1;
            }
        }
        System.out.println(maxLen);
    }
}
