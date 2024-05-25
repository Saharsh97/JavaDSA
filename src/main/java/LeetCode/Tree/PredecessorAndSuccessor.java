//package LeetCode.Tree;
//
//import LeetCode.Tree.Nodes.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PredecessorAndSuccessor {
//
//    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//        List<Integer> values = new ArrayList<>();
//        traverse(root, values);
//
//        int n = queries.size();
//        List<List<Integer>> result = new ArrayList<>(n);
//        for(int i = 0; i < n; i++){
//            int x = binarySearch(values, queries.get(i));
//            List<Integer> answer = new ArrayList<>();
//            if(x==values.size()){
//                answer.add(values.get(x-1));
//                answer.add(-1);
//            }
//            else if(x==0 && queries.get(x) != values.get(x)){
//                answer.add(-1);
//                answer.add(values.get(x));
//            }
//
//            else if(values.get(x) == queries.get(i)){
//                answer.add(values.get(x));
//                answer.add(values.get(x));
//            } else {
//                int lower = values.get(x-1);
//                int upper = values.get(x);
//                answer.add(lower);
//                answer.add(upper);
//            }
//
//            result.add(answer);
//        }
//        return result;
//    }
//
//    public void traverse(TreeNode root, List<Integer> values){
//        if(root == null) return;
//        traverse(root.left, values);
//        values.add(root.val);
//        traverse(root.right, values);
//    }
//
//    public int binarySearch(List<Integer> A, int x){
//        int n = A.size();
//        int lo = 0;
//        int hi = n-1;
//        int mid;
//        while(lo <= hi){
//            mid = (lo + hi)/2;
//            if(A.get(mid) < x){
//                lo = mid+1;
//            }
//            if(x < A.get(mid)){
//                hi = mid-1;
//            }
//            if(x == A.get(mid)){
//                return mid;
//            }
//        }
//        return lo; // points to the index where the number should have been.
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    TreeNode lower = null, upper = null;
////
////    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
////        int n = queries.size();
////        List<List<Integer>> result = new ArrayList<>(n);
////        for(int i = 0; i < n; i++){
////            List<Integer> answer = new ArrayList<>();
////
////            lower = null; upper = null;
////            search(root, queries.get(i));
////            answer.add(lower == null ? -1 : lower.val);
////            answer.add(upper == null ? -1 : upper.val);
////
////            result.add(answer);
////        }
////        return result;
////    }
////
////    public void search(TreeNode root, int x){
////        if(root == null) return;
////        if(root.val == x){
////            lower = root;
////            upper = root;
////            return;
////        }
////        if(root.val > x){
////            if(upper == null || root.val < upper.val){
////                upper = root;
////            }
////            search(root.left, x);
////        }
////        if(x > root.val){
////            if(lower == null || root.val > lower.val){
////                lower = root;
////            }
////            search(root.right, x);
////        }
////    }
//}
