package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeftView {
    ArrayList<Integer> leftView(Node root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        recur(root, map, 0);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    private void recur(Node root, Map<Integer, Integer> map, int depth){
        if(root == null){
            return;
        }
        map.putIfAbsent(depth, root.data);
        recur(root.left, map, depth+1);
        recur(root.right, map, depth+1);
    }
}
