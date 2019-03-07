package twoPointers;

import java.util.Arrays;

public class ArrayDeduplication {
    public int[] dedup(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOfRange(array, 0 , slow);
    }
}
