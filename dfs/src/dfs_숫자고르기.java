import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class dfs_숫자고르기 {
    // 순회
    // 3,1 1,2 1,3 -> 1
    // 평범하게 dfs 진행하다가, visit여부 있는 경우 set에 넣음
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = parseInt(br.readLine());
        int index = 1;
        int[][] numbers = new int[101][101];
        while(index <= count) {
            int number = parseInt(br.readLine());
            numbers[index][number] = 1;
            index++;
        }
        Set<Integer> answers = new HashSet<>();
        for(int i = 1; i <= count; i++) {
            dfs(numbers, answers, i);
        }
        System.out.println(answers.size());
        List<Integer> answerList = new ArrayList<>(answers);
        Collections.sort(answerList);
        for(int answer : answerList) {
            System.out.println(answer);
        }
    }

    public static void dfs(int[][] numbers, Set<Integer> answers, int index) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[101];
        stack.push(index);
        visit[index] = true;
        while(!stack.isEmpty()) {
            int number = stack.pop();
            for(int i = 1; i <= 100; i++){
                if(numbers[number][i] == 1) {
                    if(visit[number] && visit[i]) {
                        answers.add(number);
                        answers.add(i);
                    } else if(number == i) {
                        answers.add(i);
                        visit[i] = true;
                    }else {
                        stack.push(i);
                        visit[i] = true;
                    }
                }
            }
        }
    }
}
