package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class CreateBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return recur(0, preorder.length-1, preorder);
    }

    private TreeNode recur(int st, int en, int[] preorder){
        if(st > en){
            return null;
        }
        if(st == en){
            return new TreeNode(preorder[st]);
        }

        TreeNode root = new TreeNode(preorder[st]);
        int idx = findGreaterElementIndex(st, en, preorder);

        int leftNumbers = idx == -1 ? en-st : idx-1-st;
        int rightNumbers = idx == -1 ? 0 : en-idx+1;
        root.left = leftNumbers <= 0 ? null : recur(st+1, st + leftNumbers, preorder);
        root.right = rightNumbers <= 0 ? null : recur(st+leftNumbers+1, en, preorder);
        return root;
    }

    private int findGreaterElementIndex(int st, int en, int[] preorder){
        for(int i = st+1; i <= en; i++){
            if(preorder[i] > preorder[st]){
                return i;
            }
        }
        return -1;
    }
}
