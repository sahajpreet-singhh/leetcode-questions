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
    public ListNode oddEvenList(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode oddDummy = new ListNode(-1);  // head for odd positions
        ListNode evenDummy = new ListNode(-1); // head for even positions
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        ListNode temp = head;
        int pos = 1;

        while (temp != null) {
            if (pos % 2 != 0) { 
                odd.next = temp;
                odd = odd.next;
            } 
            else {        
                even.next = temp;
                even = even.next;
            }
            temp = temp.next;
            pos++;
        }

        even.next = null;        
        odd.next = evenDummy.next; 
        return oddDummy.next;
    }
}
