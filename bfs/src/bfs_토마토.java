import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class bfs_토마토 {
    static class Node{
        int x;
        int y;
        int z;
        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    /// 입력 받을 때, z y x 순으로 받아야 하는데, yz x 순으로 받아서 틀림ㅠㅠ
    // z y x 순으로 받는 게 맞다!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = parseInt(st.nextToken());
        int y = parseInt(st.nextToken());
        int z = parseInt(st.nextToken());
        int[][][] tomatoes = new int [x][y][z];
        int[][][] visited = new int[x][y][z];
        AtomicInteger tomatoCount = new AtomicInteger();
        AtomicInteger risenCount = new AtomicInteger();
        Queue<Node> q= new LinkedList<>();
        for(int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int k = 0; k < x; k++) {
                    tomatoes[k][j][i] = parseInt(st2.nextToken());
                    visited[k][j][i] = 0;
                    if(tomatoes[k][j][i] != -1) {
                        tomatoCount.getAndIncrement();
                        if(tomatoes[k][j][i] == 1) {
                            risenCount.getAndIncrement();
                            q.add(new Node(k,j,i));
                        }
                    }
                }
            }
        }
        if(tomatoCount.get() == risenCount.get()) {
            System.out.println(0);
            return;
        }
        AtomicInteger day = new AtomicInteger();
        sixWayBfs(tomatoes, visited, q,risenCount, day);
        if(risenCount.get() == tomatoCount.get()){
            System.out.println(day.get());
        } else {
            System.out.println(-1);
        }
    }
    public static void sixWayBfs(int[][][] tomatoes, int[][][] visited, Queue<Node> q, AtomicInteger risenCount, AtomicInteger day) {
        while(!q.isEmpty()) {
            Node node = q.poll();
            int[] dx = {0,0,-1,1,0,0};
            int[] dy = {-1,1,0,0,0,0};
            int[] dz = {0,0,0,0,1,-1};
            for (int i = 0; i < dx.length; i++) {
                int directx = dx[i] + node.x;
                int directy = dy[i] + node.y;
                int directz = dz[i] + node.z;
                if(directx < tomatoes.length && directy < tomatoes[0].length && directz < tomatoes[0][0].length && directx >= 0 && directy >= 0 && directz >= 0 && tomatoes[directx][directy][directz] == 0) {
                    if(tomatoes[directx][directy][directz] == 0) {
                        risenCount.getAndIncrement();
                    }
                    tomatoes[directx][directy][directz] = 1;
                    visited[directx][directy][directz] = 1 + visited[node.x][node.y][node.z];

                    day.set(Math.max(day.get(), visited[directx][directy][directz]));
                    q.offer(new Node(directx, directy, directz));
                }
            }
        }
    }
}