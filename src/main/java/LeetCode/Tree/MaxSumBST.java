package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxSumBST {
    int maxSum;

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        Map<TreeNode, Boolean> isValidBST = new HashMap<>();
        fillMap(root, isValidBST, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return maxSum;
    }

    public void fillMap(TreeNode root, Map<TreeNode, Boolean> isValidBST, Integer leftThreshold, Integer rightThreshold){
        if(root == null) return;
    }
}
