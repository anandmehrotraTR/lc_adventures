class Solution {
    public int maxProfit(int[] prices, int fee) {
        int b = -prices[0], s = 0, d = 0;
        for (int i = 1; i < prices.length; i++) {
            d = Math.max(d, s);
            s = b - fee + prices[i];
            b = Math.max(b, d - prices[i]);

        }
        
        return Math.max(s, d);

    }
}