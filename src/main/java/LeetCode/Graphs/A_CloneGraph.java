package LeetCode.Graphs;

import java.util.*;

public class A_CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node root) {
        if(root == null){
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()){
            Node mainNode = deque.pollFirst();
            if(visited.containsKey(mainNode.val)){
                continue;
            }
            visited.put(mainNode.val, true);

            createNewNode(mainNode, map);

            for(Node adj: mainNode.neighbors) {
                deque.add(adj);
            }
        }
        return map.get(root.val);
    }

    private void createNewNode(Node root, Map<Integer, Node> map){
        if(!map.containsKey(root.val)){
            // contains mapping of current node to the copy node.
            map.put(root.val, new Node(root.val));
        }
        Node temp = map.get(root.val);
        generateNeighbors(root, temp, map);
    }

    private void generateNeighbors(Node original, Node copy, Map<Integer, Node> map){
        for(Node adj: original.neighbors){
            if(!map.containsKey(adj.val)){
                map.put(adj.val, new Node(adj.val));
            }
        }
        for(Node adj: original.neighbors){
            copy.neighbors.add(map.get(adj.val));
        }
    }
}
