import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
    static int N;
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        int[][] island = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        int[][] weight = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                island[i][j] = parseInt(st.nextToken());
            }
        }
        int answer = Integer.MAX_VALUE;
        int num = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) {
                    continue;
                }
                if(island[i][j] == 1) {
                    search(island, visit, i, j, num);
                    num++;
                }
            }
        }
        initVisit(visit);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) {
                    continue;
                }
                if(island[i][j] != 0) {
                    int bridge = bfs(island, visit, weight, i, j, island[i][j]);
                    answer = Math.min(bridge, answer);
                    initVisit(visit);
                    initWeight(weight);
                }
            }
        }
        System.out.println(answer);
    }

    private static void initWeight(int[][] weight) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(weight[i], 0);
        }
    }

    public static void initVisit(boolean[][] visit) {
        for(int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }
    }
    public static void search(int[][] island, boolean[][] visit, int i, int j, int num) {
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(i, j));
        while(!q.isEmpty()) {
            Node node = q.poll();
            island[node.x][node.y] = num;
            for(int k = 0; k < 4; k++) {
                int dx = directX[k] + node.x;
                int dy = directY[k] + node.y;
                if(dx < 0 || dy < 0 || dx >= island.length || dy >= island.length) {
                    continue;
                }
                if(visit[dx][dy]) {
                    continue;
                }
                if(island[dx][dy] == 1) {
                    visit[dx][dy] = true;
                    q.offer(new Node(dx, dy));
                }
            }
        }
    }
    public static int bfs(int[][] island, boolean[][] visit, int[][] weight, int i, int j, int level) {
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visit[i][j] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int k = 0; k < 4; k++) {
                int dx = directX[k] + node.x;
                int dy = directY[k] + node.y;
                if(dx < 0 || dy < 0 || dx >= island.length || dy >= island.length) {
                    continue;
                }
                if(visit[dx][dy]) {
                    continue;
                }
                if(island[dx][dy] == 0) {
                    visit[dx][dy] = true;
                    q.offer(new Node(dx, dy));
                    weight[dx][dy] = weight[node.x][node.y] + 1;
                } else if(island[dx][dy] != level) {
                    return weight[node.x][node.y];
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
