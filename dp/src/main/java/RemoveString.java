import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 순회하면서 제거해야할 문자열 발견할 경우, 해당 문자열의 비용과 비교
// 문자열 한개 삭제 할 경우 비용 1점 증가하니까, 순회하면서 비용 증가시키기
//
public class RemoveString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = parseInt(br.readLine());
        Map<String, Integer> scores = new HashMap<>();
        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int score = parseInt(st.nextToken());
            scores.put(key, score);
        }
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);
        for (int index = 0; index < s.length(); index++) {
            dp[index + 1] = Math.max(dp[index] + 1, dp[index + 1]);
            for (String key : scores.keySet()) {
                if (s.startsWith(key, index)) {
                    dp[index + key.length()] = Math.max(dp[index] + scores.get(key), dp[index + key.length()]);
                }
            }
        }
        System.out.println(dp[s.length()]);
    }
}
