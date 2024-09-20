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
// 1 2 3 5 4 6 7
// 1 2 7 4 5 6 3
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        recover(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    // 순차적으로 순회해야하므로 left부터 순회 하고 right
    public void recover(TreeNode root) {
        if(root == null) {
            return;
        }
        recover(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        recover(root.right);
    }
}