package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

//
public class LeftRightWidth {

    private int left, right;

    public int widthOfBinaryTree(TreeNode root) {
        left = 0; right = 0;
        traverse(root, 0);
        return right - left;
    }

    private void traverse(TreeNode root, int side){
        if(root == null){
            return;
        }
        left = Math.min(left, side);
        right = Math.max(right, side);
        traverse(root.left, side-1);
        traverse(root.right, side+1);
    }
}
