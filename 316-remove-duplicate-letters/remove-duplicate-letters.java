import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] alpha = new int['z' - 'a' + 1];
        boolean[] visit = new boolean['z'-'a' + 1];
        for(int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            if(visit[s.charAt(i) - 'a']) {
                continue;
            }
            while(!stack.isEmpty() && s.charAt(stack.peek()) > s.charAt(i)) {
                char c = s.charAt(stack.peek());
                int alphaIndex = alpha[c - 'a'];
                if(i < alphaIndex) {
                    visit[c - 'a'] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
            visit[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(s.charAt(stack.pop()));
        }
        return sb.reverse().toString();
    }
}