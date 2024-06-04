import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class bfs_유기농배추 {
    static class Direct {
        int x;
        int y;
        public Direct(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        while(num > 0) {
            num--;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int xSize = Integer.parseInt(st.nextToken());
            int ySize = parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] vegetables = new int[xSize][ySize];
            boolean[][] visited = new boolean[xSize][ySize];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                vegetables[parseInt(st.nextToken())][parseInt(st.nextToken())] = 1;
            }
            int count = 0;
            for(int i = 0; i < xSize; i++) {
                for(int j = 0; j < ySize; j++) {
                    if(vegetables[i][j] == 1 && !visited[i][j]) {
                        bfs(vegetables, visited, i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void bfs(int[][] vegetables, boolean[][] visited, int x, int y) {
        Queue<Direct> q = new LinkedList<>();
        q.offer(new Direct(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Direct direct = q.poll();
            int[] directx = {0,1,0,-1};
            int[] directy = {1,0,-1,0};
            for(int i = 0; i < 4; i++) {
                int dx = directx[i] + direct.x;
                int dy = directy[i] + direct.y;
                if(dx < vegetables.length && dy < vegetables[0].length && dx >= 0 && dy >= 0 && vegetables[dx][dy] == 1) {
                    if(visited[dx][dy]) {
                        continue;
                    }
                    q.offer(new Direct(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }

}
