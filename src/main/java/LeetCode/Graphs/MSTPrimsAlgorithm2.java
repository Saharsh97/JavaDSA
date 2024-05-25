package LeetCode.Graphs;

import java.util.*;

public class MSTPrimsAlgorithm2 {

    Integer MAX = 100000008;

    class Node{
        int number;
        int x;
        int y;
        int weight;
        Node parent;

        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.weight = MAX;
            this.parent = this;
        }
    }

    public int minCostConnectPoints(int[][] coordinates) {
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < coordinates.length; i++){
            Node node = new Node(i, coordinates[i][0], coordinates[i][1]);
            nodes.add(node);
        }
        Map<Node, Boolean> visited = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        nodes.get(0).weight = 0;
        pq.add(nodes.get(0));
        int sum = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited.containsKey(node)){
                continue;
            }
            visited.put(node, true);
            sum += getDistance(node, node.parent);

            for(Node adj: nodes){
                if(visited.containsKey(adj) || adj.number == node.number){
                    continue;
                }

                // only the edge weight matters!
                // if this current node has the least edge weight with the new node, this current node is the parent.
                if(getDistance(adj, node) < adj.weight){
                    adj.weight = getDistance(adj, node);
                    adj.parent = node;
                    pq.add(adj);
                }
            }
        }
        return sum;
    }

    private int getDistance(Node a, Node b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
