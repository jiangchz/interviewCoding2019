package leetcode.twoPointers;

import java.util.Arrays;

public class ArrayDeduplication3 {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int begin = fast;
            //碰到重复的点，就一直在内层循环里累加fast
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            //判断是否碰到了重复
            if (fast == begin + 1) {
                array[slow++] = array[begin];
            }
        }
        return Arrays.copyOfRange(array, 0 , slow);
    }

    public int[] dedup2(int[] array) {
        //liner scan 还要回头看
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            //case 1: not duplicate
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
                continue;
            }

            //case2 : duplicate
            while (slow != -1 && fast != array.length && array[slow] == array[fast]) {
                fast++;
            }
            slow--;
        }
        return Arrays.copyOfRange(array, 0 , slow + 1);
    }
}
/*
Given a sorted integer leetcode.array, remove duplicate elements.
 For each group of elements with the same value do not keep any of them.
 Do this in-place, using the left side of the original leetcode.array and
  maintain the relative order of the elements of the leetcode.array. Return the leetcode.array after deduplication.

Assumptions

The given leetcode.array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
 */
