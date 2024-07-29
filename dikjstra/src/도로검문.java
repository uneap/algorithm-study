import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1에서 N까지 가는데 최소 시간 구하기
// 도로를 하나씩 다 막았을 때 가장 긴 최소 시간 구하기
public class 도로검문 {
    static int N,M;
    static int[] path;
    public static class Node implements Comparable<Node> {
        int start;
        int weight;
        public Node(int start, int weight){
            this.start = start;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        ArrayList<Node>[] matrix = (ArrayList<Node>[])new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            matrix[start].add(new Node(end, weight));
            matrix[end].add(new Node(start, weight));
        }
        path = new int[N + 1];
        Arrays.fill(path,-1);
        int originTime = dijkstra(matrix);
        int removedTime = 0;
        for(int i = N; i > 0; i = path[i]) {
            removedTime = Math.max(removedTime, dijkstra(matrix, path[i], i));
            if (removedTime == Integer.MAX_VALUE) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(removedTime - originTime);
    }
    public static int dijkstra(List<Node>[] matrix) {
        int[] weights = new int[N + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        weights[1] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(weights[node.start] < node.weight) {
                continue;
            }
            for(Node newNode : matrix[node.start]) {
                if(weights[newNode.start] > newNode.weight + weights[node.start]){
                    weights[newNode.start] = newNode.weight + weights[node.start];
                    pq.offer(new Node(newNode.start, weights[newNode.start]));
                    path[newNode.start] = node.start;
                }
            }
        }

        return weights[N];
    }

    public static int dijkstra(List<Node>[] matrix, int start, int end) {
        int[] weights = new int[N + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        weights[1] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(weights[node.start] < node.weight) {
                continue;
            }
            for(Node newNode : matrix[node.start]) {
                if(node.start == start && newNode.start == end) {
                    continue;
                }
                if(weights[newNode.start] > newNode.weight + weights[node.start]){
                    weights[newNode.start] = newNode.weight + weights[node.start];
                    pq.offer(new Node(newNode.start, weights[newNode.start]));
                }
            }
        }
        return weights[N];
    }
}

