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

    //greedy 写法1 用remainder的思想
    //每多条一步，看当前最远范围内的所有点，最多能留多少remainder给下一层
    //结果的保存，类似于dp，填满一个一维的result数组，比如 位置2-> 1   3-> 2步
    //用滚动数组的方式优化到其实只用一个int来记录当前最小的步数）
    //again，不是一拍脑门想出来的 orz
    public int jumpGreedy1(int[] nums) {
        int currentJumps = 0;
        int currentIndex = 1;
        int nextRemain = nums[0];
        int currentRemain = 0;
        while (currentIndex < nums.length) {
            currentJumps++;
            currentRemain = nextRemain;
            nextRemain = 0;
            while (currentRemain > 0 && currentIndex < nums.length) {
                currentRemain--;
                nextRemain--;
                nextRemain = Math.max(nextRemain, nums[currentIndex]);
                currentIndex++;
            }
        }
        return currentJumps;
    }

    //最优的greedy 答案是把remainder给简化掉了。而是保存当前jump能跳最远在哪，
    // 然后liner scan当前范围内的点最多能支持我下一步跳到哪
    public int jumpGreedy2(int[] nums) {
        int currentJumps = 0;
        int currentMax = 0;
        int nextMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > currentMax) {
                currentJumps++;
                currentMax = nextMax;
            }
            nextMax = Math.max(nextMax, nums[i] + i);

        }
        return currentJumps;
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
