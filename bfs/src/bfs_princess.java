import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_princess {
    static int N;
    static int M;
    public static class Node {
        int x;
        int y;
        boolean gram;
        int time;
        public Node(int x, int y, boolean gram, int time) {
             this.x = x;
             this.y = y;
             this.gram = gram;
             this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        int t = parseInt(st.nextToken());
        int[][] castle = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++) {
                castle[i][j] = parseInt(st.nextToken());
            }
        }
        int time = bfs(castle);
        if(time <= t && time != -1) {
            System.out.println(time);
        } else {
            System.out.println("Fail");
        }
    }

    public static int bfs(int[][] castle) {
        boolean[][][] visit = new boolean[N][M][2];
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0, castle[0][0] == 2, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == N - 1 && node.y == M - 1) {
                return node.time;
            }
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + node.x;
                int dy = directY[i] + node.y;
                if(dx < 0 || dy < 0 || dx >= castle.length || dy >= castle[0].length) {
                    continue;
                }
                if(!node.gram) {
                    if(visit[dx][dy][0]) {
                        continue;
                    }
                    if(castle[dx][dy] == 2) {
                        visit[dx][dy][0] = true;
                        q.offer(new Node(dx,dy, true, node.time + 1));
                    } else if(castle[dx][dy] == 0) {
                        visit[dx][dy][0] = true;
                        q.offer(new Node(dx,dy, false, node.time + 1));
                    }
                }else {
                    if(visit[dx][dy][1]) {
                        continue;
                    }
                    visit[dx][dy][1] = true;
                    q.offer(new Node(dx,dy, true, node.time + 1));
                }
            }
        }
        return -1;
    }
}
