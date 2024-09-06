import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.startsWith("0")) {
            System.out.println("0");
            System.exit(0);
        }
        int[] dp = new int[str.length() + 1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= str.length(); i++) {
            if(str.charAt(i - 1) - '0' >= 1 && str.charAt(i - 1) - '0' <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            if(Integer.parseInt(str.substring(i - 2, i)) >= 10 && 26 >= Integer.parseInt(str.substring(i - 2, i))) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;;
            }
        }
        System.out.println(dp[str.length()]);
    }

}
