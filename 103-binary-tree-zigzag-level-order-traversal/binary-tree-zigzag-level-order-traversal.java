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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root != null) {
            answer.add(new ArrayList<>(){
                {
                    add(root.val);
                }
            });
        }
        Map<Integer, List<Integer>> answers = new HashMap<>();
        traverse(answers, root, 0);
        List<Integer> nodes = new ArrayList<>();
        for(int key : answers.keySet()) {
            if(key % 2 == 0) {
                nodes = answers.get(key);
                Collections.reverse(nodes);
            } else {
                nodes = answers.get(key);
            }
            answer.add(nodes);
        }
        return answer;
    }
    public void traverse(Map<Integer, List<Integer>> answers, TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            List<Integer> nodes = answers.getOrDefault(depth, new ArrayList<>());
            nodes.add(node.left.val);
            answers.put(depth, nodes);
            traverse(answers, node.left, depth + 1);
        }
                if(node.right != null) {
            List<Integer> nodes = answers.getOrDefault(depth, new ArrayList<>());
            nodes.add(node.right.val);
            answers.put(depth, nodes);
            traverse(answers, node.right, depth + 1);
        }
    }
}