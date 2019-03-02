package dynamicPrograming;

public class JumpGame1 {
    public boolean canJump(int[] array) {
        boolean[] canReachEnd = new boolean[array.length];
        canReachEnd[array.length - 1] = true;

        for (int i = array.length - 2; i >= 0; i--) {
            int currentNum = array[i];
            for (int j = i + 1; j <= currentNum + i && j < array.length; j++) {
                if (canReachEnd[j]) {
                    canReachEnd[i] = true;
                    break;
                }
            }
        }
        return canReachEnd[0];
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
