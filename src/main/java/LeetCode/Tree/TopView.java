package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TopView {
    class Pair{
        int value;
        int depth;

        public Pair(int value, int height) {
            this.value = value;
            this.depth = height;
        }
    }

    ArrayList<Integer> topView(Node root) {
        Map<Integer, Pair> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        recur(root, map, 0, 0);

        for(Map.Entry<Integer, Pair> entry: map.entrySet()){
            result.add(entry.getValue().value);
        }
        return result;
    }

    private void recur(Node root, Map<Integer, Pair> map, int side, int depth){
        if(root == null){
            return;
        }
        map.putIfAbsent(side, new Pair(root.data, depth));
        if(map.get(side).depth > depth){  // This current depth is above the existing one. it will replace.
            map.put(side, new Pair(root.data, depth));
        }
        recur(root.left, map, side-1, depth+1);
        recur(root.right, map, side+1, depth+1);
    }
}
