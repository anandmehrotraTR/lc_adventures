class Solution {
    public int minDifficulty(int[] jd, int D) {
        
        int[][] dp = new int[jd.length][D+1];
  //      int d = 0;
        int n = jd.length;
        if ( n < D) {return -1;}
        for (int i = 0; i < dp.length; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        //base case
        dp[n - 1][D] = jd[n-1];
    //    System.out.println(dp[n][D]);
        
        for(int i = n - 2; i >= 0; i--) {
            dp[i][D] = Math.max(jd[i], dp[i + 1][D]);
        }

        for (int day = D - 1; day > 0; day--) {
            for (int i = day - 1; i < n - (D - day); i++) {
                int hardest = 0;
                // Iterate through the options and choose the best
                for (int j = i; j < n - (D - day); j++) {
                    hardest = Math.max(hardest, jd[j]);
                    // Recurrence relation
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j + 1][day + 1]);
                }
            }
        }
        
        /**
            State function: Least difficult job schedule for a certain day
            at least one job per day

            State function(Refined): Least difficult job schedule when starting with the ith job
            on a certain day
            variables: Day(d) AND job(i)
            Difficulty: The hardest job scheduled for that Day
            1 job per day. D days and N Jobs
            
            how many jobs to pick per day? ith index to N(total jobs) - (D(total days) - d(current day))        [exclusive].  i = d - 1(jobs are indexed at 0, days at 1) TO (N-D + d)
                    (i, N-D + d]
            
            dp[i, d] = Minimum {hardest(j, N - D + d) + dp[j + 1, d + 1]}, where j goes from i to N-D + D
                                                               i <= j< N-D + d

            Base case: When at the last day all remaning jobs need to be done
            dp[i, D] => Max difficulty of a job being taken that day

            answer/start case
            dp(0, 1) => We on the 1st day with 0 jobs(no jobs)


         */              
        return dp[0][1];
    }
}