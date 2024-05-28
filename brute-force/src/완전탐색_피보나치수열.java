import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 완전탐색_피보나치수열 {
    //숫자 입력받기
    public static int solutionInt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return parseInt(br.readLine());
    }
    // 0 1 1 2 3 5 8 ...
    // f(0) -> 0
    // f(1) -> 1
    // f(2) -> f(1) + f(0) = 1
    // f(3) -> f(1) + f(2) = 2
    // 시간 복잡도 O(2^n)
    // n = 20 이하의 수라서 재귀로 풀었음
    public static int fibonacci(int num) {
        if(num <= 0) {
            return 0;
        } else if(num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(fibonacci(solutionInt()));

    }
}