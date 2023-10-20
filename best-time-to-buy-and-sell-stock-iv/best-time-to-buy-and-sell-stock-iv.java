class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = 2 * k;
   //     System.out.println(k);
        int dp[][][] = new int[n + 1][k + 1][2];
        
        for(int i = n - 1; i >=0; i--) {
            for (int j = k - 1; j >=0; j--) {
                for (int h = 0; h < 2; h++) {
                    int profit = 0;
                    if (h == 0) {
                        profit = -prices[i] + dp[i+1][j+1][1];
                    } else {
                        profit = dp[i+1][j+1][0] + prices[i];
                    }
                    dp[i][j][h] = Math.max(profit, dp[i+1][j][h]);
                 //   System.out.println(dp[i][j][h]);
                }
            }
        }
        return dp[0][0][0];
    }
}