package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class TreeDiameter {
    int maxLenPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLenPath = 0;
        recur(root);
        return maxLenPath;
    }

    public int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recur(root.left);
        int right = recur(root.right);
        maxLenPath = Math.max(maxLenPath, left + right);
        return Math.max(left, right) + 1;
    }
}
