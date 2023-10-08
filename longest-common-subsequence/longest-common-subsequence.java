class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        if (t1.length() == 0 && t2.length() == 0) {
            return 1; // two empty strings are 1
        }
        if(t1.length() < t2.length()) {
            String temp = t2;
            t2 = t1;
            t1 = temp;
        }
        
        int[] dp = new int [t2.length() + 1];
        dp[0] = 0; // because no empty string in input. Empty strings need to be handled separately
        for (int i = 1; i <= t1.length(); i ++) {
            int topLeft = dp[0];
            // System.out.print(t1.charAt(i - 1) + " = ") ;
            // for (int v: dp) {
            //     System.out.print(v + ", ");
            // }
            System.out.println();
            for (int j = 0; j <= t2.length(); j ++) {
                int temp = dp[j];
                if (j == 0) {
                    dp[j] = 0;
                    continue;
                }
                
                dp[j] = t1.charAt(i - 1) == t2.charAt(j - 1) ? 1 + topLeft : Math.max(dp[j - 1], dp[j]);    
                topLeft = temp;
            }
        }
        return dp[t2.length()];
    }
}