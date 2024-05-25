package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.*;

public class LevelOrderTraversal {
//    class TNode{
//        TreeNode node;
//        int level;
//
//        public TNode(TreeNode node, int level) {
//            this.node = node;
//            this.level = level;
//        }
//    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Deque<TNode> deque = new ArrayDeque<>();
//        Map<Integer, List<Integer>> levelMap = new TreeMap<>();
//        deque.add(new TNode(root, 0));
//        while(!deque.isEmpty()){
//            TNode tNode = deque.pollFirst();
//            levelMap.putIfAbsent(tNode.level, new ArrayList<>());
//            levelMap.get(tNode.level).add(tNode.node.val);
//            if(tNode.node.left != null) deque.addLast(new TNode(tNode.node.left, tNode.level+1));
//            if(tNode.node.right != null) deque.addLast(new TNode(tNode.node.right, tNode.level+1));
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        for(Map.Entry<Integer, List<Integer>> entry: levelMap.entrySet()){
//            result.add(entry.getValue());
//        }
//        return result;
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode root, int depth, List<List<Integer>> result){
        if(root == null){
            return;
        }
        if(result.size() == depth) result.add(new ArrayList<>());
        result.get(depth).add(root.val);
        traverse(root.left, depth+1, result);
        traverse(root.right, depth+1, result);
    }
}
