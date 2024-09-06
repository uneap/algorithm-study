// 알파벳에 따라 가장 마지막 인덱스를 저장
// peek했을 때 해당 알파벳확인, 해당 알파벳이 현재 인덱스가 가리키는 알파벳보다 크고, peek한 알파벳의 인덱스가 더 크다면 pop
// 그렇지 않을 경우, 붙임
import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] index = new int[27];
        for(int i = 0; i < s.length();i++) {
            index[s.charAt(i) - 'a'] = i;    
        }
        Stack<Integer> stack = new Stack<>();
        Set<Character> alphabet = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                alphabet.add(s.charAt(i));
                continue;
            }
            if(alphabet.contains(s.charAt(i))) {
                continue;
            }
            while(!stack.isEmpty() && s.charAt(i) <= s.charAt(stack.peek()) && stack.peek() < index[s.charAt(stack.peek()) - 'a'] && i < index[s.charAt(stack.peek()) - 'a']) {
                alphabet.remove(s.charAt(stack.peek()));
                stack.pop();
            }

            stack.push(i);
            alphabet.add(s.charAt(i));
            
        }
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()) {
            answer.append(s.charAt(stack.pop()));
        }
        return answer.reverse().toString();
    }
}