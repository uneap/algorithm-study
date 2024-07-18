import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 4
// 3
// 6
// 8
// 7
// 5
// 2
// 1

// 1
// 2
// 3
// 4
// 5
// 6

// 1
// 2
// 3
// 4
// -
// -
// 1
// 2
// 5
// 6
// -
// 1
// 2
// 5
// 7
// 8
// -
// -
// -
// -
// -
public class StackLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] line = new int[n];
        for(int i = 0; i < n; i++) {
            line[i] = parseInt(br.readLine());
        }
        int index = 0;
        List<String> answers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n;) {
            if(line[index] >= i) {
                stack.push(i++);
                answers.add("+");
            } else {
                if(stack.pop() == line[index]) {
                    answers.add("-");
                    index++;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        while(index < n && stack.pop() == line[index]) {
            answers.add("-");
            index++;
        }
        if(!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
