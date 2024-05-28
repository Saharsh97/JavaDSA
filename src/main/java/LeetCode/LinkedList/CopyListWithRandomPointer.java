package LeetCode.LinkedList;

import LeetCode.LinkedList.Nodes.Node;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // create alternate node, between the given list.
        Node current = head;
        Node next = current.next;
        while(current != null){
            current.next = new Node(current.data);
            current.next.next = next;

            current = next;
            if(current == null) break;
            next = next.next;
        }

        // copy random pointers
        current = head;
        while(current != null){
            current.next.random = current.random != null ? current.random.next : null;

            current = current.next.next;
        }

        // copy the next pointers of both the list.
        Node newHead = head.next;
        Node p = newHead;
        Node oldHead = head;
        Node q = oldHead;
        next = p.next;

        while(p != null && q != null && next != null){
            p.next = next.next;
            q.next = next;

            p = p.next;
            q = q.next;
            if(next.next == null) break;
            next = next.next.next;
        }
        p.next = null;
        q.next = null;

        return newHead;
    }
}
