import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {
    // 0  1  2  3  4
    // 30 10 20 35 40
    // 3  0  3  5  4
    // 30 50 40 25 20
    //   0   1   2   3  4   5   6   7   8   9 ...
    // 0 0   0   0   30 30  30
    // 1 10  10  10  40 40  40
    // 2 10  10  10  40 40  40  70
    // 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        long M = parseInt(st.nextToken());
        int[] cost = new int[100];
        int[] m = new int[100];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            m[i] = parseInt(st.nextToken());
            cost[i] = parseInt(st2.nextToken());
        }
        int[][] app = new int[n][10001];
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int c = cost[i];
            int size = m[i];
            for(int j = 0; j <= 10000; j++) {
                if(i == 0) {
                    if(c <= j) {
                        app[i][j] = size;
                    }
                } else {
                    if( c <= j) {
                        app[i][j] = Math.max(app[i - 1][j], app[i - 1][j - c] + size);
                    } else {
                        app[i][j] = app[i - 1][j];
                    }
                }
                if(app[i][j] >= M) {
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}
