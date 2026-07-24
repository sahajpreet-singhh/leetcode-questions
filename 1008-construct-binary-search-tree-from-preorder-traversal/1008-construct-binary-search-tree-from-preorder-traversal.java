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
    public TreeNode insert(TreeNode root, int k){
        if(root == null) return new TreeNode(k);
        else if(k > root.val){
            if(root.right == null) root.right = new TreeNode(k);
            else insert(root.right,k);
        }
        else if(k < root.val){
            if(root.left == null) root.left = new TreeNode(k);
            else insert(root.left,k);
        }
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1 ; i < preorder.length; i++){
            root = insert(root,preorder[i]);
        }
        return root;
        
    }
}