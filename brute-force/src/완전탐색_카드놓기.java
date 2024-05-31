import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 완전탐색_카드놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int count = parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            numbers.add(br.readLine());
        }
        Set<String> answers = new HashSet<>();
        permutation(answers, new LinkedList<>(), count, numbers, new boolean[n]);
        System.out.println(answers.size());
    }
    public static void permutation(Set<String> answers, LinkedList<String> answer, int count, List<String> numbers, boolean[] visit) {
        if(count <= 0) {
            answers.add(String.join("", answer));
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            answer.add(numbers.get(i));
            permutation(answers, answer, count - 1, numbers, visit);
            answer.removeLast();
            visit[i] = false;
        }
    }
}
