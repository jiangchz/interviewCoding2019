package leetcode.slidingWindow;

public class MaxConsecutiveOnes3_LC1004 {
    public int longestOnes_v0(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int flipCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                flipCount++;
                while (flipCount > k) {
                    if (nums[left] == 0) {
                        flipCount--;
                    }
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int currentSize = 0;
        while (right < nums.length) {
            if (k > 0) {
                if (nums[right] != 1) {
                    k--;
                }
                currentSize++;
                result = Math.max(result, currentSize);
                right++;
            } else if (k == 0 && nums[right] == 1) {
                currentSize++;
                result = Math.max(result, currentSize);
                right++;
            } else { //k < 0
                if (nums[left] != 1) {
                    k++;
                }
                currentSize--;
                left++;
            }

        }
        return result;
    }

    public int longestOnes_V2(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
                while(zeroCount > k) {
                    zeroCount = nums[left] == 0 ? zeroCount - 1 : zeroCount;
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);

        }
        return max;
    }
}

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 */