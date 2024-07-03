import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dikjstra_short_path {

    // 정점 5
    // 간선 6
    // 시작 정점 1
    //
    public static class Node implements Comparable<Node> {
        int linkV;
        int weight;

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
        public Node(int linkV, int weight) {
            this.linkV = linkV;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = parseInt(st.nextToken());
        int e = parseInt(st.nextToken());
        int start = parseInt(br.readLine());
        List<Node>[] nodes = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<>();
        }
        while(e > 0) {
            e--;
            st = new StringTokenizer(br.readLine(), " ");
            nodes[parseInt(st.nextToken())].add(new Node(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }
        int[] weight = new int[v + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        dikjstra(nodes, start, weight);
        for (int i = 1; i <=v; i++){
            if (weight[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(weight[i]);
            }
        }
    }

    public static void dikjstra(List<Node>[] nodes, int start, int[] weight) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[nodes.length];
        pq.add(new Node(start, 0));
        weight[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            visit[node.linkV] = true;
            for(Node newNode: nodes[node.linkV]) {
                if(!visit[newNode.linkV]) {
                    if(weight[node.linkV] + newNode.weight < weight[newNode.linkV]){
                        weight[newNode.linkV] = weight[node.linkV] + newNode.weight;
                        pq.offer(new Node(newNode.linkV, weight[newNode.linkV]));
                    }
                }
            }
        }
    }
}