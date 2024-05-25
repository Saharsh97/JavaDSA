package LeetCode.LinkedList;

import LeetCode.LinkedList.Nodes.ListNode;

public class ReverseInGroupsOfK {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            if(length == k){
                break;
            }
            temp = temp.next;
        }
        if(length < k){
            return head;
        }

        ListNode reversedList = reverseKGroup(temp.next, k);

        ListNode current = head;
        ListNode prev = null;
        ListNode next = current.next;

        for(int i = 0; i < k; i++){
            current.next = prev;

            prev = current;
            current = next;
            if(current != null) {
                next = current.next;
            }
        }
        head.next = reversedList;
        return prev;
    }
}
