// 이진수로 변환
// 이진수 자릿수 개수 추가
// 3으로 나머지 구했을 때 0이 아닌 경우만 값 가져오기
// 십진수로 변환
import java.math.BigInteger;
class Solution {
    public int singleNumber(int[] nums) {
        int[] binaryElements = new int[33];
        for(int i = 0; i < nums.length; i++) {
            String num = Integer.toBinaryString(nums[i]);
            for(int j = 0; j < num.length(); j++) {
                if(num.charAt(j) == '1'){
                    binaryElements[num.length() - 1 - j]++;
                }
            }
        }
        String answer = "";
        for(int i = binaryElements.length - 1; i >= 0; i--) {
            if(binaryElements[i] % 3 != 0) {
                answer += "1";
            } else {
                answer += "0";
            }
        }
        return new BigInteger(answer, 2).intValue();
    }
}