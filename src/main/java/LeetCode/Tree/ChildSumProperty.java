package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

public class ChildSumProperty {
    public static int isSumProperty(Node root) {
        if(root == null){
            return 1;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(isSumProperty(root.left) == 0) return 0;
        if(isSumProperty(root.right) == 0) return 0;
        int leftVal = root.left == null ? 0 : root.left.data;
        int rightVal = root.right == null ? 0 : root.right.data;
        if(root.data != leftVal + rightVal){
            return 0;
        }
        return 1;
    }
}
