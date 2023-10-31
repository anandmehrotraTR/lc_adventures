class Solution {
    public int minPathSum(int[][] og) {
        //if (og[0][0] == 1) {return 0;}
        int[][] dp = new int[og.length][og[0].length];
    //    dp[0][0] = 1;
        for(int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = og[row][col];
                    continue;
                }
                int left = col == 0 ? Integer.MAX_VALUE : dp[row][col - 1];
                int top = row == 0  ? Integer.MAX_VALUE : dp[row  - 1][col];
                dp[row][col] = Math.min(left, top) + og[row][col];
            }
        }
        
        return dp[og.length - 1][og[0].length - 1];
        
    }
}