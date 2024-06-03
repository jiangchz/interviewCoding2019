package leetcode.dfs;

public class PartitionEqualSubsetSum_LC416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        //memo[position of input nums][target]
        Boolean[][] memo = new Boolean[nums.length][sum];

        return canDevide(nums, 0, memo, sum/2);
    }

    /**
     *      Note: 1. we need to add memo to do the puring
     *            2. we used to use halfSum and pathSum, condition should be halfSum == pathSum. We can simplify it to target = half_sum - pathSum
     *            3. We need to updatethe memo during the recursion
     */
    private boolean canDevide(int[] nums, int index, Boolean[][] memo, int target) {
        if (index == nums.length || target < 0) {
            return false;
        }

        if (target == 0 ) {
            return true;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        } //we want to know both already found true/false for position and target. We need to use Boolean instead of boolean

        return memo[index][target] = canDevide(nums, index + 1, memo, target - nums[index]) || canDevide(nums, index + 1, memo, target); //bug, the return result should used to update memo
    }
}

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
