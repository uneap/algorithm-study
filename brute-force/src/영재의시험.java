import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class 영재의시험 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = parseInt(st.nextToken());
        }
        AtomicInteger answer = new AtomicInteger();
        int[] answers = new int[10];
        find(numbers, answers, 0, answer);
        System.out.println(answer.get());
    }
    public static void find(int[] numbers, int[] answers, int depth, AtomicInteger answer) {
        if (depth == 10) {
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (answers[i] == numbers[i]) {
                    count++;
                }
            }
            if (count >= 5) {
                answer.getAndIncrement();
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if(depth >= 2 && answers[depth - 1] == answers[depth - 2] && answers[depth - 1] == i) {
                continue;
            }
            answers[depth] = i;
            find(numbers, answers, depth + 1, answer);
        }
    }
}
