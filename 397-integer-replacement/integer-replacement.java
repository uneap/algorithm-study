class Solution {
    public int integerReplacement(int n) {
        return convert((long)n, 0);
    }
    
    public int convert(long n, int count) {
        if(n == 1) {
            return count;
        }
        if(n % 2 == 0) {
            return convert(n / 2, count + 1);
        } else {
            return Math.min(convert(n + 1, count + 1), convert(n - 1, count + 1));
        }
    }
}