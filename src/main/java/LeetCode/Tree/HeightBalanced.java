package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class HeightBalanced {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recur(root.left);
        int right = recur(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
