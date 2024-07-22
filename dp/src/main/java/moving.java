import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class moving {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        for(int i= 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                miro[i][j] = parseInt(st.nextToken());
            }
        }
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
}
