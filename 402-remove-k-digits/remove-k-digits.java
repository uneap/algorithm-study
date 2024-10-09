// stack에 넣으면서, 자기보다 더 큰 애 stack peek에 있으면 뺌
import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> numbers = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            while(!numbers.isEmpty() && k > 0 && numbers.peek() > num.charAt(i) - '0') {
                numbers.pop();
                k--;
            }
            numbers.push(num.charAt(i) - '0');
        }
        while(k > 0) {
            k--;
            numbers.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!numbers.isEmpty()) {
            sb.append(numbers.pop());
        }
        String answer = sb.reverse().toString();
        while(answer.startsWith("0")) {
            answer = answer.substring(1);
        }
        if(answer.equals("")) {
            return "0";
        }
        return answer;
    }
}