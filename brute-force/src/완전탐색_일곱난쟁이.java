import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 완전탐색_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        List<Integer> key = new ArrayList<>();
        while(n > 0) {
            n--;
            key.add(parseInt(br.readLine()));
        }
        Set<List<Integer>> answers = new HashSet<>();
        search(key, answers, new LinkedList<>(), 0);
        for(List<Integer> answer : answers) {
            Collections.sort(answer);
            for(int person : answer) {
                System.out.println(person);
            }
        }
    }

    public static void search(List<Integer> key, Set<List<Integer>> answers, LinkedList<Integer> answer, int i) {
        if(!answers.isEmpty()) {
            return;
        }
        int sum = answer.stream().reduce(0, Integer::sum);
        if (answer.size() == 7 && sum == 100) {
            answers.add(new ArrayList<>(answer));
            return;
        }
        if(i == key.size()) {
            return;
        }
        search(key, answers, answer, i + 1);
        answer.add(key.get(i));
        search(key, answers, answer, i + 1);
        answer.removeLast();
    }

}
