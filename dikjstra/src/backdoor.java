import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backdoor {
    public static class Node implements Comparable<Node> {
        long weight;
        int x;
        public Node(int x, long weight) {
            this.weight = weight;
            this.x = x;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight - o.weight > 0) return 1;
            else return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        int possible[] = new int[n];
        List<Node>[] nodes = new ArrayList[n];
        while(count != n){
            nodes[count] = new ArrayList<>();
            possible[count++] = parseInt(st.nextToken());
        }
        count = 0;
        while(count++ != m) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            nodes[x].add(new Node(y, weight));
            nodes[y].add(new Node(x, weight));
        }
        long[] weight = new long[n];
        Arrays.fill(weight, Long.MAX_VALUE);
        dikjstra(nodes, possible, weight, new boolean[n]);
        if(weight[n - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(weight[n - 1]);
    }

    public static void dikjstra(List<Node>[] nodes, int possible[], long weight[], boolean visit[]) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        weight[0] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visit[node.x]) continue;
            visit[node.x] = true;
            for(Node newNode : nodes[node.x]) {
                if((newNode.x != visit.length - 1 && possible[newNode.x] == 1)) {
                    continue;
                }
                if(weight[newNode.x] > weight[node.x] + newNode.weight) {
                    weight[newNode.x] = weight[node.x] + newNode.weight;
                    pq.offer(new Node(newNode.x, weight[newNode.x]));
                }
            }
        }
    }
}
