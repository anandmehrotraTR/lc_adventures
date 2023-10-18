class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + a);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys);
        
        int tb = 0, ob = map.get(keys.get(0));
        
        for (int i = 1; i < keys.size(); i++) {
            int curr = map.get(keys.get(i));
            int temp = 0;
            if (keys.get(i) - 1 == keys.get(i-1)) {
                temp = Math.max(tb + curr, ob);
            } else {
                temp = Math.max(tb + curr, ob + curr);
            }
            tb = ob;
            ob = temp;
        }
        return ob;
    }
    
    }