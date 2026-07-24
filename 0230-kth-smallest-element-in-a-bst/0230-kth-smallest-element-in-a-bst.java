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
    public static int prev = 0;
    public static int ans = 0;    
    public void helper(TreeNode root , int key){
        if(root == null)return ;
        helper(root.left,key);
        prev +=1;
        if(prev == key){
            ans = root.val;
            return;
        }
        helper(root.right,key);

    }
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        prev = 0;
        helper(root,k);
        return ans;
        
    }
}