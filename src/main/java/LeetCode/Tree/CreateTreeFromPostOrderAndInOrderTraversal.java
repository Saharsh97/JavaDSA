package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeFromPostOrderAndInOrderTraversal {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) inorderIndex.put(inorder[i], i);
        return build(0, postorder.length-1, postorder, 0, inorder.length-1, inorder, inorderIndex);
    }

    private TreeNode build(int postOrderSt, int postOrderEn, int[] postorder, int inOrderSt, int inOrderEn, int[] inorder, Map<Integer, Integer> inorderIndex) {
        if(postOrderEn <= postOrderSt){
            return new TreeNode(postorder[postOrderEn]);
        }

        int rootValue = postorder[postOrderEn];
        TreeNode root = new TreeNode(rootValue);
        int rootValueIndex = inorderIndex.get(rootValue);

        int leftNumbers = rootValueIndex - inOrderSt;
        int rightNumbers = inOrderEn - rootValueIndex;
        root.left = leftNumbers == 0 ? null : build(postOrderSt, postOrderSt+leftNumbers-1, postorder, inOrderSt, rootValueIndex-1, inorder, inorderIndex);
        root.right = rightNumbers == 0 ? null : build(postOrderSt+leftNumbers, postOrderEn-1, postorder, rootValueIndex+1, inOrderEn, inorder, inorderIndex);
        return root;
    }
}
