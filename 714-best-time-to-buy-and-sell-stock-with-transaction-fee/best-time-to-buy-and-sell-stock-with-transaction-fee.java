// 사는 가격과 파는 가격 최댓값을 모두 측정
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = Integer.MIN_VALUE;
        int buy = 0;
        for(int i = 0; i < prices.length; i++) {
            sell = Math.max(sell, buy - prices[i]);
            buy = Math.max(buy, sell + prices[i] - fee);
        }
        return buy;
    }
}