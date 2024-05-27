package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class WidthOfBinaryTree {
    class Level{
        long level;
        long min;
        long max;

        public Level(long level) {
            this.level = level;
            this.min = Long.MAX_VALUE;
            this.max = Long.MIN_VALUE;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        Map<Long, Level> map = new HashMap<>();
        dfs(root, 0, 1, map);
        long maxDiff = 0;
        for(Map.Entry<Long, Level> entry: map.entrySet()){
            maxDiff = Math.max(maxDiff, entry.getValue().max - entry.getValue().min + 1);
        }
        return (int) maxDiff;
    }

    private void dfs(TreeNode root, long depth, long nodeNumber, Map<Long, Level> map){
        if(root == null) return;
        if(!map.containsKey(depth)) map.put(depth, new Level(depth));
        map.get(depth).min = Math.min(map.get(depth).min, nodeNumber);
        map.get(depth).max = Math.max(map.get(depth).max, nodeNumber);

        dfs(root.left, depth+1, 2*nodeNumber, map);
        dfs(root.right, depth+1, 2*nodeNumber+1, map);
    }
}
