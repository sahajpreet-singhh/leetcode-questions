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
    static int maxSum;
    public int lineSum(TreeNode root){
        if(root == null) return 0;
        int leftlineSum = lineSum(root.left);
        int rightlineSum = lineSum(root.right);
        int pathSum = root.val;
        if(leftlineSum > 0) pathSum += leftlineSum;
        if(rightlineSum > 0) pathSum += rightlineSum;
        maxSum = Math.max(maxSum,pathSum);
        return root.val + Math.max(0,Math.max(leftlineSum,rightlineSum));
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        lineSum(root);
        return maxSum;
    }
}