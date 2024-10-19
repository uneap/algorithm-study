// char로 변환
// 맨 뒤에서부터 왼쪽보다 커야 한다. 왼쪽보다 작을 경우, 9로 변환하고 왼쪽 값 -1
// 왼쪽보다 크거나 같을 경우 패스
// 
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String number = Integer.toString(n);
        char[] numbers = number.toCharArray();
        int start = numbers.length;
        for(int i = numbers.length - 1; i >= 0; i--) {
            if(i - 1 >= 0 && numbers[i - 1] > numbers[i]) {
                start = i;
                numbers[i - 1] = (char)(numbers[i - 1] - 1);
            }
        }
        for(int i = start; i < numbers.length; i++) {
            numbers[i] = '9';
        }
        number = String.valueOf(numbers);
        return Integer.parseInt(number);
    }
}