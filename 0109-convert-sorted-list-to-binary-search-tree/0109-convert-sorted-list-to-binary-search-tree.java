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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode helper(int[] arr, int lo , int hi){
        if(lo > hi)return null;
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr,lo,mid-1);
        root.right = helper(arr,mid+1,hi);
        return root;

    }
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        int idx = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int[] arr= new int[count];
        while(temp!= null){
            arr[idx] = temp.val;
            idx++;
            temp = temp.next;
        }
        return helper(arr,0,count-1);
    }
}