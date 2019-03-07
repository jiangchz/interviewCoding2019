package twoPointers;

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
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            if (fast == begin + 1) {
                array[slow++] = array[begin];
            }
        }
        return Arrays.copyOfRange(array, 0 , slow);

    }
}
/*
Given a sorted integer array, remove duplicate elements.
 For each group of elements with the same value do not keep any of them.
 Do this in-place, using the left side of the original array and
  maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
 */
