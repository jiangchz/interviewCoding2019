package dynamicPrograming;

public class JumpGame2 {
    public int canJump(int[] array) {
        int[] jumpStep = new int[array.length];
        jumpStep[array.length - 1] = 0;

        for (int i = array.length - 2; i >= 0; i--) {
            int goblaMin = Integer.MAX_VALUE;
            int currentNum = array[i];

            for (int j = i + 1; j <= currentNum + i && j < array.length; j++) {
                if (jumpStep[j] >= 0) {
                    goblaMin = Math.min(goblaMin, jumpStep[j] + 1);
                }
            }
            jumpStep[i] = goblaMin == Integer.MAX_VALUE ? -1 : goblaMin;//bug
        }
        return jumpStep[0] == Integer.MAX_VALUE ? -1 : jumpStep[0];
    }
}


/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
Determine the minimum number of jumps you need to reach the end of array.
If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.
Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 */
