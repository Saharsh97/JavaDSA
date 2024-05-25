package LeetCode.Trie;

import java.util.ArrayList;
import java.util.List;

public class MaxiumXOR {

    public int findMaximumXOR(int[] A) {
        int n = A.length;
        Trie trie = new Trie();
        int maxNumber = A[0];
        for(int x: A)
            maxNumber = Math.max(maxNumber, x);
        String binaryOfMaxNumber = convertNumberToString(maxNumber, null);

        List<String> binaryNumbers = new ArrayList<>();
        for(int x: A) {
            String binaryNumber = convertNumberToString(x, binaryOfMaxNumber.length());
            binaryNumbers.add(binaryNumber);
            trie.addWordToTrie(binaryNumber);
        }

        int maxXOR = 0;
        for(String binaryNumber: binaryNumbers){
            String targetNumber = trie.oppositeWord(binaryNumber);

            int num1 = convertStringToNumber(binaryNumber);
            int num2 = convertStringToNumber(targetNumber);
            maxXOR = Math.max(maxXOR, num2 ^ num1);
        }

        return maxXOR;
    }

    private String convertNumberToString(int number, Integer size){
        StringBuilder binary = new StringBuilder();
        while(number > 0){
            int digit = number%2;
            binary.append(digit);
            number = number>>1;
        }
        if(size != null){
            int binarySize = binary.length();
            int zerosNeeded = size - binarySize;
            binary.append("0".repeat(Math.max(0, zerosNeeded)));
        }
        return binary.reverse().toString();
    }

    private int convertStringToNumber(String word){
        int result = 0;
        int k = 1;
        for(int i = word.length()-1; i >= 0; i--){
            if(word.charAt(i) == '1'){
                result += k;
            }
            k = k << 1;
        }
        return result;
    }

    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode(0);
        }

        public void addWordToTrie(String word){
            TrieNode temp = root;
            for(Character character: word.toCharArray()){
                int c = character-48;
                if(temp.children[c] == null){
                    temp.children[c] = new TrieNode(c);
                }
                temp = temp.children[c];
            }
            temp.isLeafNode = true;
            temp.finalWord = word;
        }

        public String oppositeWord(String word){
            TrieNode temp = root;
            for(Character character: word.toCharArray()){
                int x = character-48;
                int target = character == '1' ? 0 : 1;
                if(temp.children[target] != null){
                    temp = temp.children[target];
                } else {
                    temp = temp.children[x];
                }
            }
            return temp.finalWord;
        }
    }

    class TrieNode{
        Integer character;
        TrieNode[] children;
        boolean isLeafNode;
        String finalWord;

        TrieNode(Integer character){
            this.character = character;
            this.children = new TrieNode[2];
        }
    }
}
