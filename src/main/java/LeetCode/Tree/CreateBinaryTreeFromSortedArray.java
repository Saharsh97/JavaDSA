package LeetCode.Tree;

import LeetCode.Tree.Nodes.TreeNode;

public class CreateBinaryTreeFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(0, nums.length-1, nums);
    }

    private TreeNode create(int st, int en, int[] nums){
        // base condition
        if(st > en){
            return null;
        }
        if(st == en){
            return new TreeNode(nums[st]);
        }
        int mid = st + (en-st)/2;
        TreeNode root = new TreeNode(mid);
        root.left = create(st, mid-1, nums);
        root.right = create(mid+1, en, nums);
        return root;
    }
}
