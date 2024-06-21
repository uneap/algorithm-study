import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 101
// 98
// 123 234 323 232
public class dp_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Long[][] dp = new Long[101][10];
        Arrays.fill(dp[1], 1L);
        dp[1][0] = 0L;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if(j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        long sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % 1000000000;
        }
        System.out.println(sum);
    }
}