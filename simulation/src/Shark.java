import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 초기 구름 위치 n,1 /n,2 / n-1,1 / n-1, 2
// 1. 구름 이동
// 2. 구름의 위치에 물 양 1 증가
// 3. (위치 기억 visit으로 표시)
// 4. 3에서 방문했던 곳에서 대각선 방향으로 물이 있는 바구니 수만큼 물 증가
// 5. 3에서 방문했던 곳 제외 하고 물의 양 2 줄임
//
// 1,1,2,2,0,0
// 3,0, 2, 1
public class Shark {
    static int[] directX = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] directY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] bucket;
    static boolean[][] visit;
    static boolean[][] cloud;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        int cloudCount = parseInt(st.nextToken());
        bucket = new int[N][N];
        visit = new boolean[N][N];
        cloud = new boolean[N][N];
        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true;
        for(int i = 0; i < N; i++) {
            StringTokenizer water = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                bucket[i][j] = parseInt(water.nextToken());
            }
        }
        for(int i = 0; i < cloudCount; i++) {
            st = new StringTokenizer(br.readLine());
            int d = parseInt(st.nextToken()) - 1;
            int s = parseInt(st.nextToken());
            move(d, s);
            copy();
            minus();
        }
        sum();
    }

    public static void sum() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sum += bucket[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void move(int directIndex, int count) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!cloud[i][j]) {
                    continue;
                }
                cloud[i][j] = false;
                int x = (i + (N + directX[directIndex]) * count) % N;
                int y = (j + (N + directY[directIndex]) * count) % N;
                bucket[x][y] += 1;
                visit[x][y] = true;
            }
        }
     }

    public static void copy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) {
                    int count = 0;
                    for(int k = 1; k < 8; k += 2) {
                        int dx = i + directX[k];
                        int dy = j + directY[k];
                        if(dx < N && 0 <= dx && dy < N && 0 <= dy && bucket[dx][dy] > 0) {
                            count++;
                        }
                    }
                    bucket[i][j] += count;
                }
            }
        }
    }

    public static void minus() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] || bucket[i][j] < 2) {
                    visit[i][j] = false;
                    continue;
                }
                cloud[i][j] = true;
                bucket[i][j] -= 2;
            }
        }
    }
}
