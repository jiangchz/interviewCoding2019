package dynamicPrograming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //关键点->物理意思: 表示从0 - i的子序列里，包含i点的最长升序子序列有多大
        int[] maxIncreasingCount = new int[nums.length];
        maxIncreasingCount[0] = 1;//bug! 可能当前找不到比我自身要小的节点，那么最大的升序应该为只包含我自己的序列
        for (int i = 1; i < nums.length; i++) {
            int previous = i - 1;
            maxIncreasingCount[i] = 1;
            while (previous >= 0) {
                if (nums[i] > nums[previous]) {
                    maxIncreasingCount[i] = Math.max(maxIncreasingCount[previous] + 1, maxIncreasingCount[i]);
                }
                previous--;
            }
        }
        Arrays.sort(maxIncreasingCount);
        return maxIncreasingCount[nums.length - 1];
    }
}
