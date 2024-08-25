import java.math.BigInteger;
import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        String answer = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
        BigInteger bi1 = new BigInteger(Integer.toString(o2) + Integer.toString(o1));
        return bi1.subtract(new BigInteger(Integer.toString(o1) + Integer.toString(o2))).intValue();
      }).map(String::valueOf)
            .collect(Collectors.joining(""));
        if(answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}