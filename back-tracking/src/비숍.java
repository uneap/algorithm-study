import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍 {
    static int[][] matrix;
    static int num;
    static int black;
    static int white;
    static int[] directX = {1, -1, 1, -1};
    static int[] directY = {1, -1, -1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = parseInt(br.readLine());
        matrix = new int[num][num];
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++) {
                matrix[i][j] = parseInt(st.nextToken());
            }
        }
        boolean[][] visit = new boolean[num][num];
        search(0,0, true, 0, visit);
        visit = new boolean[num][num];
        search(0, 1, false, 0, visit);
        System.out.println(black + white);
    }

    public static void search(int x, int y, boolean isBlack, int count, boolean[][] visit) {
        if(isBlack) {
            black = Math.max(count, black);
        } else {
            white = Math.max(count, white);
        }
        if(y >= num) {
            x += 1;
            y = (y % 2 == 0) ? 1 : 0;
        }
        if(x >= num) {
            return;
        }
        if(!visit[x][y] && matrix[x][y] == 1 && isPossible(x, y, visit)) {
            visit[x][y] = true;
            search(x, y + 2, isBlack, count + 1, visit);
            visit[x][y] = false;
        }
        search(x, y + 2, isBlack, count, visit);
    }

    public static boolean isPossible(int x, int y, boolean[][] visit) {
        for(int i = 0; i < 4; i++) {
            int dx = x + directX[i];
            int dy = y + directY[i];
            for(int j = 0; j < num; j++) {
                if(dx < 0 || dy < 0 || dx >= num || dy >= num) {
                    continue;
                }
                if(visit[dx][dy]) {
                    return false;
                }
                dx += directX[i];
                dy += directY[i];
            }
        }
        return true;
    }


}
