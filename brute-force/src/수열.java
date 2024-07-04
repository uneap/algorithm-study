import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(visit, false);
        permutation(m, visit, n, "");
    }

    public static void permutation(int m, boolean[]visit, int n, String answer) {
        if(m == 0) {
            System.out.println(answer);
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            permutation(m - 1, visit, n, answer + i + " ");
            visit[i] = false;
        }
    }

}
