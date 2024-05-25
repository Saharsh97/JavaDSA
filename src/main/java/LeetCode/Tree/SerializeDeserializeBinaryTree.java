package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SerializeDeserializeBinaryTree {

    Integer idx;
    public String serialize(TreeNode root) {
        List<String> data = new ArrayList<>();
        dfs(root, data);
        return String.join("I", data);
    }

    public void dfs(TreeNode root, List<String> data){
        if(root == null){
            data.add("null");
            return;
        }
        data.add(String.valueOf(root.val));
        dfs(root.left, data);
        dfs(root.right, data);
    }


    public TreeNode deserialize(String data) {
        List<String> values = List.of(data.split("I"));
        idx = 0;
        return build(values);
    }

    public TreeNode build(List<String> values){
        String data = values.get(idx++);
        if(data.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data));
        root.left = build(values);
        root.right = build(values);
        return root;
    }









//    Integer invalid = 100005;
//    Integer idx;
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root == null) return "";
//        List<String> data = new ArrayList<>();
//        Deque<TreeNode> q = new ArrayDeque<>();
//        q.add(root);
//
//        while(!q.isEmpty()){
//            TreeNode node = q.poll();
//            data.add(node.val == invalid ? "null" : String.valueOf(node.val));
//            if(node.val != invalid){
//                q.add(node.left == null ? new TreeNode(invalid) : node.left);
//                q.add(node.right == null ? new TreeNode(invalid) : node.right);
//            }
//        }
//        return String.join("I", data);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        List<String> values = List.of(data.split("I"));
//        idx = 0;
//        return traverse(values);
//    }
//
//    public TreeNode traverse(List<String> values){
//        if(idx == values.size()) return null;
//        String data = values.get(idx++);
//        String leftNode = new TreeNode();
//        if(data.equals("null")) return null;
//        TreeNode root = new TreeNode(Integer.parseInt(data));
//        root.left = traverse(values);
//        root.right = traverse(values);
//        return root;
//    }
}
