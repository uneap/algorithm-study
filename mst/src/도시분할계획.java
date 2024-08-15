import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {
    // 두개의 분리된 마을로 분할
    // 집들의 가장 root를 찾고 합친다
    static int N, M;
    static int[] parent;
    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
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
        parent = new int[N + 1];
        List<Node>[] node = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = parseInt(st.nextToken());
            int two = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            node[one].add(new Node(one, two, weight));
            node[two].add(new Node(two, one, weight));
            pq.offer(new Node(one, two, weight));
        }
        init();
        System.out.println(mst(pq));
    }

    public static int mst(PriorityQueue<Node> pq) {
        int answer = 0;
        for(int i = 0; i < N - 2;) {
            if(pq.isEmpty()){
                return answer;
            }
            Node node = pq.poll();
            if(find(node.start) == find(node.end)) {
                continue;
            }
            union(node.start, node.end);
            answer += node.weight;
            i++;
        }
        return answer;
    }

    public static void init() {
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }
    public static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(parent[a] > parent[b]) parent[a] = b;
        else parent[b] = a;
    }
}
