package leetcode.dynamicPrograming;

public class LargestSumOfSubArray {
    public int largestSum(int[] array) {
        int current = Integer.MIN_VALUE;
        int gobalMax = current;
        for (int num : array) {
            if (current > 0) {
                current += num;

            } else {
                current = num;
            }

            gobalMax = Math.max(current, gobalMax);
        }
        return gobalMax;
    }
}
