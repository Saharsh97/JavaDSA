package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

public class InOrderSuccessorAndPredecessor {
    private Node pre;
    private Node suc;

    public void findPreSuc(Node root, int key) {
        pre = null;
        suc = null;
        traverse(root, key-1, 0);
        traverse(root, key+1, 1);
    }

    public void traverse(Node root, int key, int type){
        if(root == null){
            return;
        }
        if(key > root.data){
            pre = type == 0 ? (pre == null ? root : pre.data < root.data ? root : pre) : null;
            traverse(root.right, key, type);
        }
        if(key < root.data){
            suc = type == 1 ? (suc == null ? root : suc.data > root.data ? root : suc) : null;
            traverse(root.left, key, type);
        }
        if(key == root.data){
            if(type == 0) pre = root;
            else suc = root;
        }
    }
}
