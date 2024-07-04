import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_중복허용_비오름차순제거 {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        permutation(m, n, "", 0);
    }

    public static void permutation(int m, int n, String answer, int pre) {
        if(m == 0) {
            System.out.println(answer);
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(pre > i){
                continue;
            }
            permutation(m - 1, n, answer + i + " ", i);
        }
    }

}
