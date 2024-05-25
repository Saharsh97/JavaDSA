package LeetCode.LinkedList;

import LeetCode.LinkedList.Nodes.ListNode;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        int length = 1;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        ListNode p = head;
        ListNode q = head;
        for(int i = 0; i < (length+1)/2; i++){
            q = q.next;
        }

        while(q != null && q.next != null){
            p = p.next;
            q = q.next;
        }

        ListNode l1 = head;
        ListNode l2 = length%2 != 0 ? p.next.next : p.next;
        p.next = null;

        l1 = reverseList(l1);

        while(l1 != null && l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }

    private ListNode reverseList(ListNode l1){
        ListNode current = l1;
        ListNode prev = null;
        ListNode next = current.next;

        while(next != null){
            current.next = prev;

            prev = current;
            current = current.next;
            next = current.next;
        }
        return current;
    }

}
