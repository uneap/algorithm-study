class Solution {
    public int integerReplacement(int n) {
        Map<Long, Integer> dp = new HashMap<>();
        dp.put(1L, 0);
        replacement(n, dp);
        return dp.get(Long.valueOf(n));
    }
    public int replacement(long n, Map<Long, Integer> dp) {
        if(dp.containsKey(n)) {
            return dp.get(n);
        }
        if(n == 1) {
            return 0;
        }
        if(n % 2 == 1) {
            dp.put(n, Math.min(dp.getOrDefault(n, Integer.MAX_VALUE), Math.min(replacement(n + 1, dp) + 1, replacement(n - 1, dp) + 1)));
        } else {
            dp.put(n, Math.min(dp.getOrDefault(n, Integer.MAX_VALUE), replacement(n / 2, dp) + 1));
        }
        return dp.get(n);
    }
}