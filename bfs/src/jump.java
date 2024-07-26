import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jump {
    static int N, k;
    public static class Node {
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        boolean[][] spaces = new boolean[2][N];
        for(int i = 0; i < 2; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                int space = parseInt(line[j]);
                spaces[i][j] = space == 1;
            }
        }
        if(bfs(spaces)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static boolean bfs(boolean[][] spaces) {
        Queue<Node> q = new LinkedList<>();
        int[] directY = {1, -1};
        q.offer(new Node(0,0, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < 2; i++) {
                int dx = node.x;
                int dy = node.y + directY[i];
                if(dy >= 0 && dy < N && spaces[dx][dy]) {
                    q.offer(new Node(dx, dy,node.count + 1));
                    spaces[dx][dy] = false;
                } else if(dy >= N) {
                    return true;
                }
            }
            if(node.x == 0) {
                if(node.y + k >= N) {
                    return true;
                }
                if(node.y + k < N && spaces[node.x + 1][node.y + k]) {
                    q.offer(new Node(node.x + 1, node.y + k, node.count + 1));
                    spaces[node.x + 1][node.y + k] = false;
                }
            } else {
                if(node.y + k >= N) {
                    return true;
                }
                if(node.y + k < N && spaces[node.x -1][node.y + k]) {
                    q.offer(new Node(node.x -1, node.y + k, node.count + 1));
                    spaces[node.x - 1][node.y + k] = false;
                }
            }
            spaces[0][node.count] = false;
            spaces[1][node.count] = false;
        }
        return false;
    }
}
