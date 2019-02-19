package sortingAlgorithms;
import java.util.Arrays;

import static sortingAlgorithms.QuickSort.swap;

public class KSmallestElementsInArray_QuickSelect {
    public  static int[] findKSmallestElements(int[] numbers, int k) {
        int start = 0;
        int end = numbers.length - 1;
        int pivotIndex = start + (end - start) / 2;

        while (pivotIndex != k - 1) {
            pivotIndex = partition(start, end, pivotIndex, numbers);
            if (pivotIndex > k - 1) {
                end = pivotIndex - 1;
            } else if (pivotIndex < k - 1) {
                start = pivotIndex + 1;
            }
            pivotIndex = start + (end - start) / 2;
        }
        return Arrays.copyOf(numbers, k);
    }

    private static int partition(int start, int end, int pivotIndex, int[] numbers) {
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, end);
        pivotIndex = end--;

        while (start < end) {
            if (numbers[start] < pivot) {
                start++;
            } else if (numbers[end] > pivot) {
                end--;
            }

            if (start < end) {
                swap(numbers, start++, end--);
            }
        }
        swap(numbers, start, pivotIndex);
        return start;
    }

    public static void main(String args[]) {
        int[] numbers = new int[] {9, 8 ,7, 6, 5, 4, 3, 2,1};
        int[] result = findKSmallestElements(numbers, 4);
        for (int num: result) {
            System.out.println(num);
        }

    }
}
