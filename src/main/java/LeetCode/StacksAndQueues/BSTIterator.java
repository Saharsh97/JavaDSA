package LeetCode.StacksAndQueues;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        update(root);
    }

    public void update(TreeNode root){
        if(root == null) return;
        TreeNode temp = root;
        stack.push(temp);
        while(temp.left != null) {
            stack.push(temp.left);
            temp = temp.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        update(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
