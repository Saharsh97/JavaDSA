package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class MaxPathSum {
    int maxPathSum = 0;
    int MIN_VALUE = -100005;

    public int maxPathSum(TreeNode root) {
        maxPathSum = MIN_VALUE;
        recur(root);
        return maxPathSum;
    }

    public int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = root.left == null ? MIN_VALUE : recur(root.left);
        int right = root.right == null ? MIN_VALUE : recur(root.right);
        int singlePath = Math.max(left, right) + root.val;
        int self = root.val;
        int doublePath = root.val + left + right;
        maxPathSum = Math.max(maxPathSum, Math.max(self, Math.max(singlePath, doublePath)));
        return Math.max(self, singlePath);
    }
}
