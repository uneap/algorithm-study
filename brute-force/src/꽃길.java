import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꽃길 {
    static int N;
    static boolean[][] visit;
    static int[][] matrix;
    static int[] directX = {0,0,1,-1};
    static int[] directY = {1,-1,0,0};
    static int minimumSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        visit = new boolean[N][N];
        matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                matrix[i][j] = parseInt(st.nextToken());
            }
        }
        getFlowers(0, 0);
        System.out.println(minimumSum);
    }

    public static void getFlowers(int count, int sum) {
        if(count == 3) {
            minimumSum = Math.min(minimumSum, sum);
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j] || !has4Leaves(i, j)) {
                    continue;
                }
                getFlowers(count + 1, sum + getCost(i, j));
                visit[i][j] = false;
                initVisit(i, j);
            }
        }
    }

    public static void initVisit(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int dx = x + directX[k];
            int dy = y + directY[k];
            visit[dx][dy] = false;
        }
    }
    public static int getCost(int x, int y) {
        int sum = matrix[x][y];
        for (int k = 0; k < 4; k++) {
            int dx = x + directX[k];
            int dy = y + directY[k];
            visit[dx][dy] = true;
            sum += matrix[dx][dy];
        }
        return sum;
    }
    public static boolean has4Leaves(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int dx = x + directX[k];
            int dy = y + directY[k];
            if (dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dx][dy]) {
                return false;
            }
        }
        return true;
    }

}
