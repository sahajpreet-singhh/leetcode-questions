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
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p== null || q ==  null)return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public TreeNode invert(TreeNode root){
        if(root == null)return root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = invert(l);
        root.left = invert(r);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        root.left=invert(root.left);
        return isSameTree(root.left,root.right);

    }
}