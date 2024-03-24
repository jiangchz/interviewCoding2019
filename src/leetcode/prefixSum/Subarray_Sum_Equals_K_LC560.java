package leetcode.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/subarray-sum-equals-k/
 *
 *  Trick1: 2 way to do prefix sum
 *          Sum(i - j) = Sum(0 - j) - Sum(0 - i) + val(i)
 *
 *    Or    Sum(i - j) = Sum(0 - j) -  Sum(0 - (i - 1))
 *          Sum(0 - (i - 1))  =  i == 0 ? 0 :  Sum(0 - (i - 1))
 *
 *  trick2: scan though from first number to last
 *          When we check number at index J. preSum means totalSum from 0 - J
 *          we want to check how many start index i can be combined to have range sum i - j can be added up to K
 *          k = preSum(J) - preSum(I)
 *          Why NOT k = preSum(J) - preSum(I) + value(I)? The meaning of preSum(J) - preSum(I) means from I - J NOT including I
 *          We WILL add 0, 1 into the counter map, means we have 1 option to choose 0 number.
 */
public class Subarray_Sum_Equals_K_LC560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumCount = new HashMap<>();

        preSumCount.put(0, 1);

        int preSum = 0;
        int result = 0;
        for (int num : nums) {
            preSum += num;

            if (preSumCount.containsKey(preSum - k)) {
                result += preSumCount.get(preSum - k);
            }

            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}