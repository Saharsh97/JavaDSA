package LeetCode.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val-n2.val;
            }
        });
        int n = lists.length;
        for(int i = 0; i < n; i++){
            pq.add(lists[i]);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while(pq.size() > 0){
            ListNode top = pq.poll();
            current.next = top;
            if(top.next != null){
                pq.add(top.next);
            }
            current = current.next;
        }
        return head.next;
    }
}
