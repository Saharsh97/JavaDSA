package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

public class PopulateNextRightPointers {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        root.next = root.next != null ? root.next : null;   // if already filled, let it be. otherwise its null.
        root.left.next = root.right;    // left child points to right child.
        // right child points to my (current root) next's left child.
        root.right.next = root.next == null ? null : root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
