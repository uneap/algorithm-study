import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일채우기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        long[] dp = new long[num + 3];
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;
        long[] sum = new long[num + 3];
        sum[0] = 1;
        sum[1] = 1;
        sum[2] = 1;
        sum[3] = 1;
        for(int i = 4; i <= num; i++) {
            sum[i] += (sum[i - 1] + dp[i - 3]) % 1000000007;
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3 + 2 * sum[i]) % 1000000007;
        }
        System.out.println(dp[num] %  1000000007);
    }
}
