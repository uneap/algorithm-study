import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수열의구간평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        int[] arr = new int[N];
        long[] prefixSum = new long[N];
        Map<Long, Integer> sumAndCount = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = parseInt(st.nextToken());
            if(i >= 1) {
                prefixSum[i] += prefixSum[i - 1] + arr[i];
            } else {
                prefixSum[i] = arr[i];
            }
        }
        long answer = 0;
        for(int i = 0; i < N; i++) {
            long sum = prefixSum[i] - (long) K * (i + 1);
            answer += sumAndCount.getOrDefault(sum, 0);
            sumAndCount.put(sum, sumAndCount.getOrDefault(sum, 0) + 1);
        }
        System.out.println(answer + sumAndCount.getOrDefault(0L, 0));

        // 2         : 1   3   2   2
        //prefix Sum:  1   4   6   8
        //           : -1 0   0  0   -> (sum - k * 구간의 길이) 0일 경우 -> 구간 평균이 k에 도달했다. 굳이 빼줄 필요가 없다.
        //           0이 아닐 경우, 구간 평균이 k에 도달하지 못했음. 그 값만큼의 누적합을 빼주면 상쇄됨.
        //           범위는 그 누적합을 구한 지점 부터 현 지점까지
        //:            0  0   1  3  + 3
    }
}
