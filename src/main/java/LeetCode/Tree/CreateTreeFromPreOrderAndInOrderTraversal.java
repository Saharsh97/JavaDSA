package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.*;

public class CreateTreeFromPreOrderAndInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);
        return build(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inorderIndex);
    }

    private TreeNode build(int preOrderSt, int preOrderEn, int[] preorder, int inOrderSt, int inOrderEn, int[] inorder, Map<Integer, Integer> inorderIndex) {
        if(preOrderSt >= preOrderEn){
            return new TreeNode(preorder[preOrderSt]);
        }

        int rootValue = preorder[preOrderSt];
        TreeNode root = new TreeNode(rootValue);
        int rootValueIndex = inorderIndex.get(rootValue);

        int leftNumbers = rootValueIndex - inOrderSt;
        int rightNumbers = inOrderEn - rootValueIndex;
        root.left = leftNumbers == 0 ? null : build(preOrderSt+1, preOrderSt+leftNumbers, preorder, inOrderSt, rootValueIndex-1, inorder, inorderIndex);
        root.right = rightNumbers == 0 ? null : build(preOrderSt+leftNumbers+1, preOrderEn, preorder, rootValueIndex+1, inOrderEn, inorder, inorderIndex);
        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length == 0){
//            return null;
//        }
//
//        int value = preorder[0];
//        TreeNode root = new TreeNode(value);
//
//        Set<Integer> leftNumbers = new HashSet<>();
//        Set<Integer> rightNumbers = new HashSet<>();
//        int idx = 0;
//        for(; idx < inorder.length; idx++){
//            if(inorder[idx] == value) break;
//        }
//
//        for(int i = 0; i < idx; i++) leftNumbers.add(inorder[i]);
//        for(int i = idx+1; i < inorder.length; i++) rightNumbers.add(inorder[i]);
//
//        int[] leftInorder = new int[idx];
//        int[] rightInorder = inorder.length-idx-1 > 0 ? new int[inorder.length-idx-1] : new int[0];
//        for(int i = 0; i < idx; i++) leftInorder[i] = inorder[i];
//        for(int i = idx+1; i < inorder.length; i++) rightInorder[i-idx-1] = inorder[i];
//
//        int[] leftPreorder = new int[idx];
//        int[] rightPreorder = inorder.length-idx-1 > 0 ? new int[inorder.length-idx-1] : new int[0];
//        int p = 0; int q = 0;
//        for(int i = 1; i < preorder.length; i++){
//            if(leftNumbers.contains(preorder[i])) leftPreorder[p++] = preorder[i];
//            if(rightNumbers.contains(preorder[i])) rightPreorder[q++] = preorder[i];
//        }
//
//        root.left = buildTree(leftPreorder, leftInorder);
//        root.right = buildTree(rightPreorder, rightInorder);
//        return root;
//    }
}
