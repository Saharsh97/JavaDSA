package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class MaxHeight {
    public int maxDepth(TreeNode root) {
        Integer maxDepth = 0;
        recur(root, 0, maxDepth);
        return maxDepth;
    }

    private void recur(TreeNode root, Integer depth, Integer maxDepth){
        if(root == null){
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        recur(root.left, depth+1, maxDepth);
        recur(root.right, depth+1, maxDepth);
    }
}
