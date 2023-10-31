class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = -prices[0], rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int tempBuy = Math.max(rest - prices[i], buy);
            rest = Math.max(rest, sell);
            sell = buy + prices[i];
            buy = tempBuy;
        }

        return Math.max(rest, sell);


        // int[] dp = new int[prices.length + 2];
        // for (int i = prices.length - 1; i >=0; i--) {
        //     dp[i] = dp[i + 1]; //do nothing
        //     for (int k = i + 1; k < prices.length; k++) { //sell at k, cooldown at k + 2
        //         int profit = prices[k] - prices[i];
        //         dp[i] = Math.max(dp[i], profit + dp[k + 2]);
        //     }
        // }
        // return dp[0];
    }
}