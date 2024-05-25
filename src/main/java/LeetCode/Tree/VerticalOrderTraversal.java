package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    class Pair{
        int value;
        int height;

        public Pair(int value, int height) {
            this.value = value;
            this.height = height;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();

        recur(root, map, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Pair>> entry: map.entrySet()){
            entry.getValue().sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                  return o1.height == o2.height ? o1.value - o2.value : o1.height - o2.height;
                }
            });
            result.add(entry.getValue().stream().map(e -> e.value).toList());
        }
        return result;
    }

    private void recur(TreeNode root, Map<Integer, List<Pair>> map, int side, int depth){
        if(root == null){
            return;
        }
        map.putIfAbsent(side, new ArrayList<>());
        map.get(side).add(new Pair(root.val, depth));
        recur(root.left, map, side-1, depth+1);
        recur(root.right, map, side+1, depth+1);
    }
}
