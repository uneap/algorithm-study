import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 소난다 {
    static int N;
    static int[] cows;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken());
        N = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cows = new int[M];
        for(int i = 0; i < M; i++) {
            cows[i] = parseInt(st.nextToken());
        }
        prime = new boolean[9001];
        Arrays.fill(prime, true);
        for(int i = 2; i <= Math.sqrt(9000); i++) {
            if(!prime[i]) {
                continue;
            }
            for(int j = i * i; j <= 9000; j+= i) {
                prime[j] = false;
            }
        }
        List<Integer> cowWeights = new ArrayList<>();
        getFlyingCows(cowWeights, 0, 0, 0);
        if(cowWeights.isEmpty()) {
            System.out.print(-1);
            System.exit(0);
        }
        cowWeights.stream().distinct().sorted().forEach(cow -> System.out.print(cow + " "));
        System.out.println();
    }
    public static void getFlyingCows(List<Integer> cowWeights, int sum, int count, int index) {
        if(count == N) {
            if(prime[sum]) {
                cowWeights.add(sum);
            }
            return;
        }
        if(index == cows.length) {
            return;
        }
        getFlyingCows(cowWeights, sum + cows[index], count + 1, index + 1);
        getFlyingCows(cowWeights, sum, count, index + 1);
    }
}
