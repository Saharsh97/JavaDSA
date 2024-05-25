package LeetCode.Tree;


import LeetCode.Tree.Nodes.TreeNode;

public class FlattenBinarySearchTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;

        flatten(root.left);
        flatten(root.right);

        // one sided trees.
        if(root.left == null){
            return;
        }
        if(root.right == null){
            root.right = root.left;
            root.left = null;
            return;
        }


        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;
        TreeNode temp = root.right;
        if(temp == null){
            return;
        }
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }
}
