package twoPointers;

import static sortingAlgorithms.QuickSort.swap;

public class Move0sToTheEnd {
    public int[] moveZero1(int[] array) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
            fast++;

        }
        while(slow < array.length) {
            array[slow++] = 0;
        }
        return array;
    }
    public int[] moveZero2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            while (left <= right && array[left] != 0) {
                left++;
            }
            while (left <= right && array[right] == 0) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
            }
        }
        return array;
    }
}
