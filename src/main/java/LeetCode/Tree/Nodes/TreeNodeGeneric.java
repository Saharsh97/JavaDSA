package LeetCode.Tree.Nodes;

public class TreeNodeGeneric<T>{
    public T data;
    public TreeNodeGeneric<T> left;
    public TreeNodeGeneric<T> right;

    public TreeNodeGeneric(T data, TreeNodeGeneric<T> left, TreeNodeGeneric<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
