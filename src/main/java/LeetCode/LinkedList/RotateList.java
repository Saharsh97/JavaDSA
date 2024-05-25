package LeetCode.LinkedList;

import LeetCode.LinkedList.Nodes.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        k = k % length;
        if(k == 0){
            return head;
        }

        temp = head;
        for(int i = 0; i < k; i++){
            temp = temp.next;
        }

        ListNode newHead = head;
        ListNode originalHead = head;
        ListNode prev = null;

        while(temp != null){
            temp = temp.next;
            prev = newHead;
            newHead = newHead.next;
        }

        prev.next = null;

        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = originalHead;

        System.out.println(newHead.val + " " + prev.val + " " + originalHead.val);
        return newHead;
    }
}
