package leetcode.dynamicPrograming;

public class TargetSum_LC494 {
    //version 1:  Sum_positive = (target + sum_total) /2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum+= num;
        }

        if (sum < target || target < -sum || sum + target % 2 == 1) {
            return 0;
        }

        return subsetSum(nums, (sum + target) / 2);
    }

    /**
        We convert the problem to : Sum_postive = (target + sum_total) /2
            Here is why:
            sum_postive - sum_negative = target
            sum_postive - sum_negative  + sum_postive + sum_negative  = target + sum_postive + sum_negative
            2 * sum_postive = target + sum_total

         * sub-problem: dp[i] represents number of possible ways to reach target i with positive number
         * base case: dp[0] = 1  //One way to reach index 0
         * induction rule: dp[i] += dp[i - num]

    */
    private int subsetSum(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    //version 2: Similar to jump game dp[i + num] += dp[i]
    /**
     We convert the problem to :
     - Sum ..... 0 ....[target].. Sum
     0       ....sum.   [target + sum]    ..2Sum

     * sub-problem: dp[i] represents number of possible ways to reach target i
     * base case: dp[sum] = 1  //One way to reach sum = 0
     * induction rule: dp[i + num] += dp[i]

     */
    public int findTargetSumWays_v2(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target > sum || target < -sum || (sum + target) % 2 == 1) {
            return 0;
        }

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int num : nums) {
            int[] temp = new int[2 * sum + 1]; //since we can jump forward and backward, so we need to define temp here
            for (int i = 0; i < 2 * sum + 1; i++) {
                if (dp[i] != 0) {
                    temp[i + num] += dp[i];
                    temp[i - num] += dp[i];
                }
            }
            dp = temp;
        }
        return dp[target + sum];
    }

    //version 3:
    /**


     * sub-problem: dp[i][j] represents number of possible ways to reach sum j by using first ith items
     * base case: dp[0][sum] = 1, we able to get 0 with select 0 number
     * induction rule:
            dp[i][j] += dp[i - 1][j + nums[i - 1]] if j + nums[i - 1] <= sum * 2
            dp[i][j] += dp[i - 1][j - nums[i - 1]] if j - nums[i - 1] >= 0

     */
    public int findTargetSumWays_v3(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(target > sum || target < -sum || (sum + target) % 2 == 1)   return 0;


        //dp[i][j] i: number count, j: sum value
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                int num = nums[i - 1];

                if (j - num >= 0) {
                    dp[i][j] +=dp[i - 1][j - num];
                }

                if (j + nums[i - 1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + num];
                }
            }
        }
        return dp[nums.length][sum + target];
    }
}



/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 */
