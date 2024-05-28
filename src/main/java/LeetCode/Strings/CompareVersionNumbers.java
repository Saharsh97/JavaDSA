package LeetCode.Strings;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<String> words1 = new ArrayList<>(List.of(version1.split("\\.")));
        List<String> words2 = new ArrayList<>(List.of(version2.split("\\.")));
        adjustSize(words1, words2);
        int n = words1.size();
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(words1.get(i)) > Integer.parseInt(words2.get(i))) return 1;
            if(Integer.parseInt(words1.get(i)) < Integer.parseInt(words2.get(i))) return -1;
        }
        return 0;
    }

    private void adjustSize(List<String> words1, List<String> words2){
        int n = words1.size(); int m = words2.size();
        int diff = n-m;
        if(diff > 0) {
            for(int i = 0; i < diff; i++) words2.add("0");
        } else {
            for(int i = 0; i < -diff; i++) words1.add("0");
        }
    }
}
