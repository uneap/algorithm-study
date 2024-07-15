import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 젤다 {
    public static class Rupee implements Comparable<Rupee> {
        int num;
        int x;
        int y;
        public Rupee(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Rupee rupee) {
            return this.num - rupee.num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sequence = 1;
        while(true) {
            int num = parseInt(br.readLine());
            if(num == 0) {
                break;
            }
            int cave[][] = new int[num][num];
            boolean visit[][] = new boolean[num][num];
            for(int i = 0; i < num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < num; j++) {
                    cave[i][j] = parseInt(st.nextToken());
                }
            }
            int[][] weight = new int[num][num];
            for(int i = 0; i < num; i++) {
                Arrays.fill(weight[i], Integer.MAX_VALUE);
            }
            dijkstra(cave, visit, weight);
            System.out.println("Problem " + sequence++ + ": " + weight[num - 1][num - 1]);
        }
    }
    public static void dijkstra(int[][] cave, boolean[][] visit, int[][] weight) {
        PriorityQueue<Rupee> pq = new PriorityQueue<>();
        pq.offer(new Rupee(cave[0][0], 0, 0));
        weight[0][0] = cave[0][0];
        int directX[] = {1,-1, 0, 0};
        int directY[] = {0,0, 1, -1};
        while(!pq.isEmpty()) {
            Rupee rupee = pq.poll();
            visit[rupee.x][rupee.y] = true;
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + rupee.x;
                int dy = directY[i] + rupee.y;
                if(dx < 0 || dy < 0 || dx >= cave.length || dy >= cave[0].length) {
                    continue;
                }
                if(visit[dx][dy]) {
                    continue;
                }
                if(weight[dx][dy] >= cave[dx][dy] + rupee.num) {
                    weight[dx][dy] = cave[dx][dy] + rupee.num;
                    pq.offer(new Rupee(weight[dx][dy], dx, dy));
                }
            }
        }
    }
}
