import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 재귀_트리 {
    static class Node{
        Node left;
        Node right;
        String name;
        Node(String name) {
            this.name = name;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        Map<String, Node> nodes =  new HashMap<>();
        for(int i = 0 ; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Node root;
            String name = st.nextToken();
            if(nodes.containsKey(name)) {
                root = nodes.get(name);
            } else {
                root = new Node(name);
            }
            String leftName = st.nextToken();
            Node left = leftName.equals(".") ? null : nodes.containsKey(leftName) ? nodes.get(leftName) : new Node(leftName);
            String rightName = st.nextToken();
            Node right = rightName.equals(".") ? null : nodes.containsKey(rightName) ? nodes.get(rightName) : new Node(rightName);
            root.left = left;
            root.right = right;
            nodes.put(root.name, root);
            if(left != null && !nodes.containsKey(left.name)) {
                nodes.put(left.name, left);
            }
            if(right != null && !nodes.containsKey(right.name)) {
                nodes.put(right.name, right);
            }
        }
        Node root = nodes.get("A");
        preTraverse(root);
        System.out.println();
        middleTraverse(root);
        System.out.println();
        postTraverse(root);

    }

    public static void preTraverse(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.name);
        preTraverse(node.left);
        preTraverse(node.right);
    }
    public static void middleTraverse(Node node) {
        if(node == null) {
            return;
        }
        preTraverse(node.left);
        System.out.print(node.name);
        preTraverse(node.right);
    }
    public static void postTraverse(Node node) {
        if(node == null) {
            return;
        }
        preTraverse(node.left);
        preTraverse(node.right);
        System.out.print(node.name);
    }

}
