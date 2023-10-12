class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[]dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <=s.length(); i++) {
            int j = 0;
            while(!dp[i] && j <= i - 1) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                j++;
            }
        }        
        return dp[s.length()];
    }
}