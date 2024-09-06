import java.util.*;
// stack에 넣음
// stack이 비지 않았을 때, stack.peek()에서 뽑은 애와 순회하는 애 비교, stack이 더 클 경우 k가 0이 아닐 때 pop
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            while(!stack.isEmpty() && stack.peek() - '0' > num.charAt(i) - '0' && k != 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k != 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String answer = sb.reverse().toString();
        while(answer.startsWith("0")) {
            answer = answer.substring(1);
        }
        if(answer.equals("")){
            return "0";
        }
        return answer;
    }
}