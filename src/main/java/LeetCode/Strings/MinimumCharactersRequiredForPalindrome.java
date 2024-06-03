package LeetCode.Strings;

public class MinimumCharactersRequiredForPalindrome {
    public int solve(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        String text = str + "#" + reverse;
        int[] lps = generateLPS(text);
        int n = text.length();
        return lps[n-1] - str.length();
    }

    private int[] generateLPS(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int i = 1, j = 0;
        while(i < m && j < m){
           if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
           } else {
               if (j != 0) {
                   j = lps[j - 1];
               } else {
                   i++;
               }
           }
        }
        return lps;
    }
}

// 1. I would want to first get the longest palindrome in given string, in O(n) time
// 2. this will give me the centre around which I will make the complete palindrome.
// since whole thing will be a palindrome, from the real centre to start of given string, that should also be a palindrome.
// This is the property of centre of palindrome.
// hence for the real centre, its prefix string will be equal to suffix of its reverse.
// hence, do text = str + # + reverse. apply lps.