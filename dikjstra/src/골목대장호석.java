import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골목대장호석 {
    static int N, M, A, B, C;
    static int minWeight = Integer.MAX_VALUE;
    static List<Node>[] nodes;
    static int[] weight;
    // C - weight 가장 큰 값으로..
    public static class Node implements Comparable<Node> {
        int x;
        int weight;
        int originWeight;
        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
            this.originWeight = weight;
        }
        public Node(int x, int weight, int originWeight) {
            this.x = x;
            this.weight = weight;
            this.originWeight = originWeight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        A = parseInt(st.nextToken());
        B = parseInt(st.nextToken());
        C = parseInt(st.nextToken());
        nodes = new List[N + 1];
        weight = new int[N + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            nodes[start].add(new Node(end, weight));
            nodes[end].add(new Node(start, weight));
        }
        binarySearch();
        if(weight[B] == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        } else {
            System.out.println(weight[B]);
        }
    }

    public static int dijkstra(double maxWeight) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, 0));
        weight[A] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.x == B) {
                return weight[node.x];
            }
            if(weight[node.x] < node.originWeight) {
                continue;
            }
            for(Node newNode : nodes[node.x]) {
                if(newNode.originWeight > maxWeight) {
                    continue;
                }
                if(node.weight + newNode.originWeight <= C && weight[newNode.x] > Math.max(weight[node.x], newNode.originWeight)) {
                    weight[newNode.x] = Math.max(weight[node.x], newNode.originWeight);
                    pq.offer(new Node(newNode.x, node.weight + newNode.originWeight, weight[newNode.x]));
                }
            }
        }
        return -1;
    }

    public static void binarySearch() {
        double left = 0, right = 1e9+1;
        while(left + 1 < right) {
            double mid = (left + right) / 2;
            if (dijkstra(mid) == -1) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}