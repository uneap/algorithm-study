import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class 단절점과단절선 {
    public static class Node {
        public int nodeOne;
        public int nodeTwo;
        public Node(int nodeOne, int nodeTwo) {
            this.nodeOne = nodeOne;
            this.nodeTwo = nodeTwo;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = parseInt(br.readLine());
        ArrayList<Integer>[] nodes = new ArrayList[size + 1];
        Node[] lines = new Node[size - 1];
        for(int i = 1; i <= size; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = parseInt(st.nextToken());
            int node2 = parseInt(st.nextToken());
            nodes[node1].add(node2);
            nodes[node2].add(node1);
            lines[i] = new Node(node1, node2);
        }
        int num = parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());
            boolean tree = true;
            if(t == 1) {
                if(nodes[k].size() >= 2) {
                    tree = false;
                }
            } else {
                tree = false;
            }
            if(tree) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
