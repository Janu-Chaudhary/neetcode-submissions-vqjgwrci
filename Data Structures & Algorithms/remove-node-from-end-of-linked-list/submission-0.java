/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode curr = head;

        while (curr != null){
            length += 1;
            curr = curr.next;
        }

        int del = length - n;

        if (del == 0){
            return head.next;
        }

        int index = 0;

        curr = head;

        while (index != del-1){
            curr = curr.next;
            index += 1;
        }

        curr.next = curr.next.next;


        return head;


        
    }
}
