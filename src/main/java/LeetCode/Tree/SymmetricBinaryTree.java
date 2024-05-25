package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    private boolean symmetric(TreeNode left, TreeNode right){
        return (left == null && right == null) ||
                (left != null && right != null && left.val == right.val && symmetric(left.left, right.right) && symmetric(left.right, right.left));
    }
}
