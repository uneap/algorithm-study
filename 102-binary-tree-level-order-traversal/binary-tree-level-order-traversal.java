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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        if(root != null){
            answers.add(new ArrayList<>(){{
                add(root.val);
            }});
        }
        Map<Integer, List<Integer>> answer = new HashMap<>();
        traverse(0, answer, root);
        for(int key : answer.keySet()) {
            answers.add(answer.get(key));
        }
        return answers;
        
    }
    public void traverse(int depth, Map<Integer, List<Integer>> answer, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            List<Integer> nodes = answer.getOrDefault(depth, new ArrayList<>());
            nodes.add(root.left.val);
            answer.put(depth, nodes);
            traverse(depth + 1, answer, root.left);
        }
        if(root.right != null) {
            List<Integer> nodes = answer.getOrDefault(depth, new ArrayList<>());
            nodes.add(root.right.val);
            answer.put(depth, nodes);
            traverse(depth + 1, answer, root.right);
        }
    }
}