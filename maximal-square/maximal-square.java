class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int n = matrix.length, m = matrix[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }
        
        for(int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j] == 0 ? 0 
                            : 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
            }    
        }
        int ans = 0;
         for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j] * dp[i][j]);
            }
         }
        return ans;
    }
}