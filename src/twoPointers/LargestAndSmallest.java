package twoPointers;

public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        int size = array.length;
        sortToLargerAndSmallHalf(array);
        int[] results = new int[2];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= size/2; i++) {
            result = result < array[i] ? result : array[i];
        }
        results[1] = result;
        result = Integer.MIN_VALUE;
        for (int i = size/2; i < size; i++) {
            result = result > array[i] ? result : array[i];
        }
        results[0] = result;
        return results;
    }
    private void sortToLargerAndSmallHalf(int[] array) {
        int size = array.length;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }
            left++;
            right--;
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
/*
Key point: Need to find largest and smallest in o(n) input.
           Separate to find smallest in the small half and find the largest in the large half.
 */