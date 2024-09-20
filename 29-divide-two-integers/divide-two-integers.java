// 모든 수는 1과 2의 거듭제곱으로 표현될 수 있으며, 비트 연산을 통해 빠른 결과를 도출해내고자 한다.
class Solution {
    public int divide(int dividend, int divisor) {
        long sign = 1;
        if((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0)) {
            sign = -1;
        }
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long count = 0;
        long answer = 0;
        while(n >= d){
            count = 0;
            while(n > (d << (count + 1))) {
                count++;
            }
            n -= d << count;
            answer += (1 << count);
        }
        if(answer*sign >= (long)1 << 31) {
            return Integer.MAX_VALUE;
        }
        if(answer * sign <= 1 << 31){
            return Integer.MIN_VALUE;
        }
        return (int)answer * (int)sign;
    }
}