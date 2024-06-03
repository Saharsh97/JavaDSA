package LeetCode.Graphs;

import java.util.*;

// both Prims and Kruskal depend on Edges.
// in Prims, use PQ to take least edges.
// in Kruskals, sort the edges once by weight.
public class KruskalAlgorithm {
    class Edge{
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    int[] parent;
    int[] size;

    public int spanningTree(int n, int E, List<List<int[]>> adj){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);
        List<Edge> sortedEdges = new ArrayList<>();
        for(int u = 0; u < n; u++){
            List<int[]> edges = adj.get(u);
            for(int[] x: edges){
                int v = x[0];
                int w = x[1];
                sortedEdges.add(new Edge(u, v, w));
            }
        }
        sortedEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        int sum = 0;
        for(Edge edge: sortedEdges){
            int u = edge.u;
            int v = edge.v;

            int parentOfU = findParent(u);
            int parentOfV = findParent(v);
            if(parentOfU == parentOfV) continue;

            sum += edge.w;
            int sizeOfU = size[parentOfU];
            int sizeOfV = size[parentOfV];
            if(sizeOfU < sizeOfV){
                merge(parentOfU, parentOfV);
            } else {
                merge(parentOfV, parentOfU);
            }
            if(size[parentOfU] == n || size[parentOfV] == n) break;
        }
        return sum;
    }

    private int findParent(int vertex){
        if(parent[vertex] == vertex){
            return vertex;
        }
        return findParent(parent[vertex]);
    }

    private void merge(int src, int dest){
        parent[src] = dest;
        size[dest] += size[src];
    }

}
