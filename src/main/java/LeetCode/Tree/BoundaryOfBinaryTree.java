package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

import java.util.*;

public class BoundaryOfBinaryTree {
    ArrayList<Integer> boundary(Node root) {
        Map<Integer, Node> leftMap = new LinkedHashMap<>();
        leftView(root, 0, leftMap);

        Map<Integer, Node> bottomMap = new LinkedHashMap<>();
        bottomView(root, 0, 0, bottomMap);

        Map<Integer, Node> rightMap = new LinkedHashMap<>();
        rightView(root, 0, rightMap);
        List<Node> rightList = new ArrayList<>();
        for(Map.Entry<Integer, Node> entry: rightMap.entrySet()){
            rightList.add(entry.getValue());
        }
        List<Node> reverseRightList = new ArrayList<>();
        for(int i = rightList.size()-1; i >= 0; i--){
            reverseRightList.add(rightList.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        Set<Node> set = new HashSet<>();
        for(Map.Entry<Integer, Node> entry: leftMap.entrySet()){
           if(!set.contains(entry.getValue())){
               set.add(entry.getValue());
               result.add(entry.getValue().data);
           }
        }
        for(Map.Entry<Integer, Node> entry: bottomMap.entrySet()){
            if(!set.contains(entry.getValue())){
                set.add(entry.getValue());
                result.add(entry.getValue().data);
            }
        }
        for(Node node: reverseRightList){
            if(!set.contains(node)){
                set.add(node);
                result.add(node.data);
            }
        }
        return result;
    }

    private void leftView(Node root, int depth, Map<Integer, Node> leftMap){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        leftMap.putIfAbsent(depth, root);
        leftView(root.left, depth+1, leftMap);
        leftView(root.right, depth+1, leftMap);
    }

    private void bottomView(Node root, int depth, int side, Map<Integer, Node> bottomMap){
        if(root == null) return;
        bottomView(root.left, depth+1, side-1, bottomMap);
        if(root.left == null && root.right == null) {
            bottomMap.put(side, root);
        }
        bottomView(root.right, depth+1, side+1, bottomMap);
    }

    private void rightView(Node root, int depth, Map<Integer, Node> rightMap){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        rightMap.putIfAbsent(depth, root);
        leftView(root.right, depth+1, rightMap);
        leftView(root.left, depth+1, rightMap);
    }
}
