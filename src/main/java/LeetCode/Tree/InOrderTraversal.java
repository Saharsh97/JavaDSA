package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        recur(path, root);
        return path;
    }

    public void recur(List<Integer> path, TreeNode root){
        if(root == null){
            return;
        }
        recur(path, root.left);
        path.add(root.val);
        recur(path, root.right);
    }
}
