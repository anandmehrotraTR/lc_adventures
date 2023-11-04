class Solution {
    public int minCost(int[][] costs) {
        
        int r = 0, b = 0, g = 0;
        
        for (int i = 0; i < costs.length; i++) {
            int newR = Math.min(b, g) + costs[i][0];
            int newB = Math.min(r, g) + costs[i][1];
            int newG = Math.min(r, b) + costs[i][2];
            r = newR;
            b = newB;
            g = newG;
        }
        
        return Math.min(r, Math.min(b, g));
    }
}