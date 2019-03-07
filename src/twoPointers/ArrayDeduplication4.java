package twoPointers;

import java.util.Arrays;

public class ArrayDeduplication4 {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            if (slow == -1 || array[slow] != array[fast]) {
                array[++slow] = array[fast++];
            } else {
                while (fast < array.length && array[slow] == array[fast]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOfRange(array, 0 , slow + 1);
    }
}
/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly,
from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
