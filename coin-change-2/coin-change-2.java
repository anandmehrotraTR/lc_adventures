class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //2D to 1D dp-> C relies on c + 1 only 
        // and the amount is the only factor that varies form o to amount
        
        dp[0] = 1; 
        
        for(int c = coins.length - 1; c >= 0; c--) {
            for (int a = 1; a <= amount; a++) {
                if (coins[c] > a ) {
                    //don't pick the current coin, just continue
                   // dp[c][a] = dp[c+1][a];
                    continue;
                } else {
                    //pick the coin, don't pick is already satisfied by doing a + on dp[a]
                    dp[a] += dp[a - coins[c]];
                }
            }
        }
        return dp[amount];
    }
}