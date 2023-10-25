class Solution {
    public int numWays(int n, int k) {
        if (n < 3) {
            return (int) Math.pow(k, n);
        }
        
        int twoBack = k, oneBack =  k *  k;
        for (int i = 3; i <= n; i++) {
            int temp = (k - 1) * (twoBack + oneBack);
            twoBack = oneBack;
            oneBack = temp;
        }
        
        return oneBack;
    }
}