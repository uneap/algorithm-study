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
    public List<TreeNode> generateTrees(int n) {
        List<List<Integer>> nodes = new ArrayList<>();
        permutation(nodes, new LinkedList<>(), new boolean[n + 1]);
        List<TreeNode> answers = new ArrayList<>();
        Set<String> keys = new HashSet<>();
        for(int i = 0; i < nodes.size(); i++) {
            TreeNode node = null;
            for(int j = 0; j < nodes.get(i).size(); j++) {
                node = makeBST(nodes.get(i).get(j), node);
            }
            String key = makeKey(node);
            if(!keys.contains(key)) {
                keys.add(key);
                answers.add(node);
            }
        }
        return answers;
    }
    
    public String makeKey(TreeNode node) {
        if(node == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("/");
        sb.append(makeKey(node.left));
        sb.append("/");
        sb.append(makeKey(node.right));
        sb.append("/");
        return sb.toString();
    }
    
    public TreeNode makeBST(int value, TreeNode root) {
        TreeNode nextNode = new TreeNode(value);
        if(root == null) {
            root = nextNode;
        } else {
           root = addNode(root, nextNode); 
        }
        return root;
    }
    
    public TreeNode addNode(TreeNode root, TreeNode nextNode) {
        if(root == null) {
            root = nextNode;
        } else if(root.val > nextNode.val) {
            root.left = addNode(root.left, nextNode);
        } else if(root.val < nextNode.val) {
            root.right = addNode(root.right, nextNode);
        }
        return root;
    }
    public void permutation(List<List<Integer>> answers, LinkedList<Integer> answer, boolean[] visit) {
        if(answer.size() == visit.length - 1) {
            answers.add(new ArrayList<>(answer));
            return;
        }
        for(int i = 1; i < visit.length; i++) {
            if(visit[i]) {
                continue;
            }
            answer.add(i);
            visit[i] = true;
            permutation(answers, answer, visit);
            visit[i] = false;
            answer.removeLast();
        }
    }
}