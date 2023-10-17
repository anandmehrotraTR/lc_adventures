class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        int gl = 0;
        for(int a : nums) {
            if(lis.size() == 0 || a > lis.get(lis.size() - 1)) {
                lis.add(a);
            } else {
                int ip = Collections.binarySearch(lis, a);
            //    System.out.println(ip);
                if (ip < 0) { 
                    // if the same value is found, respect the one before so the sequence
                    //can grow
                    ip = Math.abs(ip + 1);
                    lis.set(ip, a);
                    // int size = lis.size();
                    // for (int i = ip; i < size; i++) {
                    //     lis.remove(ip);
                    // }
                
               //     lis.add(a);
                }
            }
        //    System.out.println(lis);
            
            gl = Math.max(gl, lis.size());
        }
        
        
        
        return gl;
    }
}