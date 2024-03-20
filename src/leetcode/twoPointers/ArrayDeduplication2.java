package leetcode.twoPointers;

import java.util.Arrays;

public class ArrayDeduplication2 {
    public int[] dedup2(int[] array) {
        // Write your solution here
        if (array.length <= 2) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            for (int counter = 0; counter < 2 && begin < fast; counter++){
                array[slow++] = array[begin++];
            }
        }
        return Arrays.copyOfRange(array, 0 , slow);
    }

    //optimal solution
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 2) {
            return array;
        }

        int end = 1;
        for (int i = 2; i < array.length; i ++) {
            if (array[i] != array[end - 1]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end+1);
    }
}
