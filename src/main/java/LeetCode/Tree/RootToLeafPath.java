package LeetCode.Tree;

import LeetCode.Tree.Nodes.Node;

import java.util.ArrayList;

public class RootToLeafPath {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        recur(root, path, result);

        return result;
    }

    static void recur(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }
        recur(root.left, path, result);
        recur(root.right, path, result);
        path.removeLast();
    }
}
