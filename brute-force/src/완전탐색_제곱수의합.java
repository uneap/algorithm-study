import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 40 -> 25 + 15 -> 25 + 9 + 6 -> 25 + 9 + 4 + 2 -> 3 + 2 -> 5
// 11339 -> 11338 + 1 -> 11337 + 1 ->
public class 완전탐색_제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        int[] arr = new int[50001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 1;
        arr[0] = 0;
        for(int i = 2; i <= num; i++) {
            for(int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i - j*j] + 1, arr[i]);
            }
        }
        System.out.println(arr[num]);
    }
}
