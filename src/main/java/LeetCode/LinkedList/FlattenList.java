package LeetCode.LinkedList;

import LeetCode.LinkedList.Nodes.ListNode;
import LeetCode.LinkedList.Nodes.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenList {
    public Node flatten(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        Node temp = root;
        while(temp != null) {
            pq.add(temp);
            temp = temp.next;
        }

        Node head = pq.poll();
        Node tail = head;
        tail.bottom = null;
        if(tail.bottom != null) {
            pq.add(tail.bottom);
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.bottom!=null){
                pq.add(node.bottom);
            }
            tail.bottom = node;
            tail = tail.bottom;
            tail.bottom = null;
        }
        return head;
    }
}
