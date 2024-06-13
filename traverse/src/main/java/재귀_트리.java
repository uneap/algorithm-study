import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 재귀_트리 {
    static class Node{
        Node left;
        Node right;
        char name;
        Node(char name) {
            this.name = name;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        Node[] nodes =  new Node[num];
        Arrays.fill(nodes, null);
        for(int i = 0 ; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char name = st.nextToken().charAt(0);
            char leftName = st.nextToken().charAt(0);
            char rightName = st.nextToken().charAt(0);

            Node root = nodes[name - 'A'] != null ? nodes[name - 'A'] : new Node(name);
            root.left = leftName == '.' ? null : nodes[leftName - 'A'] != null ? nodes[leftName - 'A'] : new Node(leftName);
            root.right = rightName == '.' ? null : nodes[rightName - 'A'] != null ? nodes[rightName - 'A'] : new Node(rightName);
            nodes[name - 'A'] = root;
            if(root.left != null) {
                nodes[leftName - 'A'] = root.left;
            }
            if(root.right != null) {
                nodes[rightName - 'A'] = root.right;
            }

        }
        preTraverse(nodes[0]);
        System.out.println();
        middleTraverse(nodes[0]);
        System.out.println();
        postTraverse(nodes[0]);
        System.out.println();
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
        middleTraverse(node.left);
        System.out.print(node.name);
        middleTraverse(node.right);
    }
    public static void postTraverse(Node node) {
        if(node == null) {
            return;
        }
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.print(node.name);
    }

}
