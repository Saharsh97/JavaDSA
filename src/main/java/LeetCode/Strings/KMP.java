package LeetCode.Strings;

public class KMP {
    public int strStr(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = generateLPS(pattern);
        int i = 0, j = 0;
        while(i < n) {
            while(i < n && j < m && text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if(j == m){ // pattern found;
                return i - m;
            }
            if(j != 0) {
                j = lps[j - 1];
                continue;
            }

            i++;
        }
        return -1;
    }

    private int[] generateLPS(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int i = 1, j = 0;
        while(i < m && j < m){
            while(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }

            if(j != 0){
                j = lps[j-1];
            }
            else {
                i++;
            }
        }
        return lps;
    }


}


// o n i o n s
// 0 0 0 1 2 0