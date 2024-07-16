import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class moving {
    static int N;
    static int M;
    public static class Miro {
        int x;
        int y;
        int weight;
        public Miro(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        int[][] weight = new int[N][M];
        for(int i= 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                Arrays.fill(weight[i], Integer.MIN_VALUE);
                miro[i][j] = parseInt(st.nextToken());
            }
        }
//        dijkstra(miro, weight);
        System.out.println(dp(miro));
    }

    public static int dp(int[][] miro) {
        int[] directX = {-1,0,-1};
        int[] directY = {0,-1,-1};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int number = 0;
                for(int k = 0; k < 3; k++) {
                    int dx = i + directX[k];
                    int dy = j + directY[k];
                    if(dx < 0 || dy < 0) {
                        continue;
                    }
                    number = Math.max(number, miro[dx][dy]);
                }
                miro[i][j] += number;
            }
        }
        return miro[N - 1][M - 1];
    }
//
//    public static void dijkstra(int[][] miros, int[][] weight) {
//        boolean[][] visit = new boolean[N][M];
//        PriorityQueue<Miro> pq = new PriorityQueue<>();
//        int[] directX = {1,0,1};
//        int[] directY = {0,1,1};
//        pq.offer(new Miro(0,0, miros[0][0]));
//        weight[0][0] = 0;
//        visit[0][0] = true;
//        while(!pq.isEmpty()) {
//            Miro miro = pq.poll();
//            for(int i = 0; i < 3; i++) {
//                int dx = miro.x + directX[i];
//                int dy = miro.y + directY[i];
//                if(dx >= N || dy >= M) {
//                    continue;
//                }
//                if(visit[dx][dy]) {
//                    continue;
//                }
//                if(weight[dx][dy] < miro.weight + miros[dx][dy]) {
//                    weight[dx][dy] = miros[dx][dy] + miro.weight;
//                    pq.offer(new Miro(dx, dy, weight[dx][dy]));
//                    visit[dx][dy] = true;
//                }
//            }
//        }
//    }
}
