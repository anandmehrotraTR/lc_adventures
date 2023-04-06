class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> vals = new HashSet<Integer>();
        for(int i : nums2) {
            vals.add(i);
        }
        int common = 10;
        for(int i : nums1) {
            if(vals.contains(i)) {
                common = Math.min(common, i);
            }
        }
        if(common < 10) {
            return common;
        }
        int num1 = 10, num2 = 10;
        for(int i : nums1) {
            num1 = Math.min(num1, i);
        }
        for(int i : nums2) {
            num2 = Math.min(num2, i);
        }
        return num1 <= num2 ? num1 * 10 + num2 : num2 * 10 + num1;
        
        //if no common, return smallest from each
        
        // else return the common
        
    }
}