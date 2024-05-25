//package LeetCode.Graphs;
//
//import java.util.*;
//
//public class DetectCycleUsingBFS {
//
//    public boolean canFinish(int n, int[][] edges) {
//        List<Integer>[] graph = new List[n];
//        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            graph[u].add(v);
//        }
//
//        for(int i = 0; i < n; i++){
//            if(bfsContainsCycle(i, graph)){
//                return false;   // not possible to schedule
//            }
//        }
//        return true;
//    }
//
//    public boolean bfsContainsCycle(int startNode, List<Integer>[] graph){
//        Deque<Integer> deque = new ArrayDeque<>();
//        Set<Integer> set = new HashSet<>();
//
//        deque.add(startNode);
//        while(!deque.isEmpty()){
//            int vertex = deque.pollFirst();
//
//        }
//    }
//}
