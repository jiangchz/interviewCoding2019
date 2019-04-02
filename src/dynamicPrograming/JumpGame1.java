package dynamicPrograming;

public class JumpGame1 {
    //from right to left
    public boolean canJump(int[] array) {
        boolean[] canReachEnd = new boolean[array.length];
        //canReachEnd[i]的物理意义： 从i点能不能跳到末尾的index
        //所以canJump[lastIndex] = true
        //同时也是左大段 + 右小段的思想 左大段意思是
        // 左边的部分通过小问题的结果构造出到 j ～ lastindex 问题的结果，右小段是能否从i点跳到j点
        canReachEnd[array.length - 1] = true;
        for (int i = array.length - 2; i >= 0; i--) {
            int currentNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (canReachEnd[j] && i + currentNum >= j) {
                    canReachEnd[i] = true;
                    break;
                }
            }
        }
        return canReachEnd[0];
    }

    //from left to right
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        //canJump[i]的物理意义： 从起点能不能跳到index i
        //所以canJump[0] 是在0点能跳到最后一个index
        //同时也是左大段 + 右小段的思想 左大段意思是
        // 左边的部分通过小问题的结果构造出到0 ～ i 问题的结果，右小段是右边能否通过i点一次跳到末端
        boolean[] canJump = new boolean[length];
        canJump[0] = true;

        for (int i = 1; i < length; i++) {
            for (int j = 0 ; j < i; j++) {
                if (canJump[j] && j + nums[j] >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[length - 1];
    }

    //greedy
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longest >= i) {
                longest = Math.max(longest, i + nums[i]);
            }
        }
        return longest >= nums.length - 1;
    }
}


/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
 Determine if you are able to reach the last index.

Assumptions

The given array is not null and has length of at least 1.
Examples

{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

{2, 1, 1, 0, 2}, we are not able to reach the end of array

最优解是greedy 从左往右扫一遍 O(N)
dp 方法是o(n^2)
 */
