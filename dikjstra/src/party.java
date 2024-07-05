import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 아이들이 x에 도착했다가 다시 돌아와야 하기 때문에 reverse와 기본으로 갔던 거를 구한 후 더함.
public class party {
    static int maxDistance = 0;
    public static class Node implements Comparable<Node>{
        int x;
        int weight;
        public Node(int x, int weight) {
            this.x = x;
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
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int x = parseInt(st.nextToken());
        List<Node>[] nodes = new ArrayList[n + 1];
        List<Node>[] reverseNodes = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
            reverseNodes[i] = new ArrayList<>();
        }
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int source = parseInt(st.nextToken());
            int destination = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            nodes[source].add(new Node(destination, weight));
            reverseNodes[destination].add(new Node(source, weight));
        }
        for(int i = 1; i <= n; i++) {
            if(i == x) {
                continue;
            }
            int sourceDistance = dikjstra(nodes, n, i, x);
            int endDistance = dikjstra(reverseNodes, n, i, x);
            maxDistance = Math.max(maxDistance, sourceDistance + endDistance);
        }

        System.out.println(maxDistance);
    }

    private static int dikjstra(List<Node>[] nodes, int n, int source, int x) {
        boolean visit[] = new boolean[n + 1];
        int distance[] = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));
        distance[source] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visit[node.x]) {
                continue;
            }
            visit[node.x] = true;
            for (Node newNode : nodes[node.x]) {
                if(distance[newNode.x] > newNode.weight + distance[node.x]) {
                    distance[newNode.x] = newNode.weight + distance[node.x];
                    pq.offer(new Node(newNode.x, distance[newNode.x]));
                }
            }
        }
        return distance[x];
    }
}
