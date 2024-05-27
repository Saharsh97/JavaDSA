package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MGraphColoring {
    class Node{
        int vertex;
        List<Node> adjacentNodes;
        int color;

        public Node(int vertex) {
            this.vertex = vertex;
            this.adjacentNodes = new ArrayList<>();
            this.color = -1;
        }
    }
    int colors;
    Node[] nodes;

    public boolean graphColoring(boolean g[][], int m, int n) {
        initialiseGraph(g, m, n);

        for(int i = 0; i < n; i++){
            if(dfs(i, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int vertex, int nodesColored){
        if(nodesColored == nodes.length) return true;

        int assignedColor = getAssignedColor(vertex);
        if(assignedColor == -1) return false;

        nodes[vertex].color = assignedColor;

        for(Node adj: nodes[vertex].adjacentNodes){
            if(nodes[adj.vertex].color == -1 && dfs(adj.vertex, nodesColored+1)){
                return true;
            }
        }
        assignedColor = -1;
        return false;
    }

    private int getAssignedColor(int vertex){
        int assignedColor = -1;
        for(int color = 0; color < colors; color++){
            boolean canBeTaken = true;
            for(Node adj: nodes[vertex].adjacentNodes){
                if(adj.color == color){
                    canBeTaken = false;
                    break;
                }
            }
            if(canBeTaken){
                assignedColor = color;
                break;
            }
        }
        return assignedColor;
    }

    private void initialiseGraph(boolean[][] g, int m, int n){
        colors = m;
        nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!g[i][j]) continue;
                nodes[i].adjacentNodes.add(nodes[j]);
            }
        }
    }
}
