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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
        
    }
    public boolean traverse(TreeNode node, Integer max, Integer min) {
        if(node == null) {
            return true;
        }
        if(max != null && node.val >= max) {
            return false;
        }
        if(min != null && node.val <= min) {
            return false;
        }
        return traverse(node.left, node.val, min)
        && traverse(node.right, max, node.val);
    }
}