class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int c = coins.length - 1; c >= 0; c--) {
            for (int a = 1; a <= amount; a++) {
                if (coins[c] > a ) {
                    dp[c][a] = dp[c+1][a];
                } else {
                    dp[c][a] = dp[c][a - coins[c]] + dp[c + 1][a];
                }
            }
        }
        return dp[0][amount];
    }
}