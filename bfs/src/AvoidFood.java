import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AvoidFood {
    public static class Food {
        int x;
        int y;
        public Food(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        int[][] foods = new int[N + 1][M + 1];
        boolean[][] visit = new boolean[N + 1][M + 1];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            foods[parseInt(st.nextToken())][parseInt(st.nextToken())] = 1;
        }
        System.out.println(search(foods, visit));
    }

    public static int search(int[][] foods, boolean[][] visit) {
        int maximum = 0;
        for(int i = 0; i < foods.length; i++) {
            for(int j = 0; j < foods[i].length; j++) {
                if(foods[i][j] == 1) {
                    int count = bfs(i,j, foods, visit);
                    maximum = Math.max(count, maximum);
                }
            }
        }
        return maximum;
    }

    public static int bfs(int i, int j, int[][] foods, boolean[][] visit) {
        Queue<Food> q = new LinkedList<>();
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        q.offer(new Food(i, j));
        visit[i][j] = true;
        int count = 1;
        while(!q.isEmpty()) {
            Food food = q.poll();
            for(int k = 0; k < 4; k++) {
                int dx = directX[k] + food.x;
                int dy = directY[k] + food.y;
                if(dx < 0 || dy < 0 || dx >= foods.length || dy >= foods[0].length) {
                    continue;
                }
                if(visit[dx][dy]){
                    continue;
                }
                if(foods[dx][dy] == 1){
                    q.offer(new Food(dx,dy));
                    visit[dx][dy] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
