import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class bfs_movingPeople {
    // 10,v' 15,v' 20,v'
    // 20,v' 30,v' 25,v
    // 40,v 22,v 10,v
    // 4way
    // 1. 한번에 visited 된 곳 합 / visit 영역 개수
    // 2. 방문되지 않은 곳 한번 확인, 없으면 나옴
    // 3. 연합 갱신
    // 다시 시작
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = parseInt(st.nextToken());
        int l = parseInt(st.nextToken());
        int r = parseInt(st.nextToken());
        int[][] world = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                world[i][j] = parseInt(st.nextToken());
            }
        }
        search(world, l, r);
    }
    public static void search(int[][] world, int l, int r) {
        boolean out = true;
        int count = 0;
        while(true) {
            count++;
            int sum = 0;
            boolean[][] visited = new boolean[world.length][world[0].length];
            List<Node> unity = new ArrayList<>();
            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    if (!visited[i][j]) {
                        bfs(world, visited, new Node(i, j), l, r, unity);
                        if (unity.size() == 1) {
                            out = true;
                            continue;
                        }
                    }
                }
            }
            for (Node n : unity) {
                sum += world[n.x][n.y];
            }
            System.out.println(sum + " " + unity.size());
            sum /= unity.size();
            for (Node n : unity) {
                world[n.x][n.y] = sum;
                System.out.println(sum);
            }
            if(out) {
                System.out.println(count);
                return;
            }
        }
    }
    public static void bfs(int[][] world, boolean[][]visited, Node start, int l, int r, List<Node> unity) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        unity.add(start);
        visited[start.x][start.y] = true;
        int directx[] = {0,0,1,-1};
        int directy[] = {1,-1,0,0};
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < 4; i++) {
                int dx = directx[i] + node.x;
                int dy = directy[i] + node.y;
                if(dx < world.length && dx >= 0 && dy < world[0].length && dy >= 0 && !visited[dx][dy]) {
                    int difference = Math.abs(world[node.x][node.y] - world[dx][dy]);
                    if(difference <= r && difference >= l) {
                        visited[dx][dy] = true;
                        unity.add(new Node(dx, dy));
                        q.add(new Node(dx, dy));
                    }
                }
            }
        }
    }
}
