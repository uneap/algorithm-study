// 언제 사고 팔든 가격은 동일함. 매일매일 사고 파는 걸로 해서 이익 나면 바로 판다.
class Solution {
    public int maxProfit(int[] prices) {
        int stock = prices[0];
        int answer = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - stock > 0) {
                answer += prices[i] - stock;
            }
            stock = prices[i];
        }
        return answer;
    }
}