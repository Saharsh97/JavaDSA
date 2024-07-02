package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class A_ValidBST {
    public boolean isValidBST(TreeNode root) {
        return recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recur(TreeNode root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.val < minValue || root.val > maxValue) return false;
        return recur(root.left, minValue, root.val) && recur(root.right, root.val, maxValue);
    }

//    class Data{
//        boolean validBST;
//        long min;
//        long max;
//
//        public Data(boolean validBST){
//            this.validBST = validBST;
//            this.max = Long.MIN_VALUE;
//            this.min = Long.MAX_VALUE;
//        }
//
//        public Data(boolean validBST, long min, long max) {
//            this.validBST = validBST;
//            this.min = min;
//            this.max = max;
//        }
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        Data data = recur(root);
//        return data.validBST;
//    }
//
//    private Data recur(TreeNode root){
//        if(root == null){
//            return new Data(true);
//        }
//        if(root.left == null && root.right == null){
//            return new Data(true, root.val, root.val);
//        }
//
//        Data leftData = recur(root.left);
//        if(!leftData.validBST) return leftData;
//        Data rightData = recur(root.right);
//        if(!rightData.validBST) return rightData;
//
//        boolean isRootValidBST = leftData.max < root.val && root.val < rightData.min;
//        return new Data(isRootValidBST,
//                Math.min(root.val, Math.min(leftData.min, rightData.min)),
//                Math.max(root.val, Math.max(leftData.max, rightData.max))
//        );
//    }
}
