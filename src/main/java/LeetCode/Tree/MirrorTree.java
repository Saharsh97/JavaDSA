package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

public class MirrorTree {

    public void mirror(Node node) {
        if(node == null) return;
        Node temp = node.right;
        node.right = node.left;
        node.left = temp;

        mirror(node.left);
        mirror(node.right);
    }

//    public void mirror(Node node) {
//        if(node == null){
//            return;
//        }
//        Node newNode = new Node(node.data);
//
//        recur(node.left, newNode.right);
//        recur(node.right, newNode.left);
//
//        node = newNode;
//    }
//
//    private void recur(Node main, Node copy){
//        if(main == null){
//            return;
//        }
//        copy.left = main.right != null ? new Node(main.right.data) : null;
//        copy.right = main.left != null ? new Node(main.left.data) : null;
//
//        recur(main.left, copy.right);
//        recur(main.right, copy.left);
//    }
}
