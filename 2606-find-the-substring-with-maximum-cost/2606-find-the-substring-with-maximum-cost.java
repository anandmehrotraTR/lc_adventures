class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] map = new int[26];
        Arrays.fill(map, -1001);
        for(int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i) - 'a'] = vals[i];
        }
        int gm = 0;
        int lm = 0;
        for(int i = 0; i < s.length(); i++) {
            int cost = map[s.charAt(i) - 'a'] == -1001 ? s.charAt(i) - 'a' + 1 : map[s.charAt(i) - 'a'];
            lm = Math.max(cost, cost + lm);
            gm = Math.max(gm, lm);
        }
        
        return gm;
    }
}