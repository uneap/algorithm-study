import java.math.*;
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numbers, (a, b) -> {
            BigInteger num1 = new BigInteger(Integer.toString(a) + Integer.toString(b));
            BigInteger num2 = new BigInteger(Integer.toString(b) + Integer.toString(a));
            return num2.compareTo(num1);
        });
        
        String answer = numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""));
        if(answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}