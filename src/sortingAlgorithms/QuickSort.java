package sortingAlgorithms;

public class QuickSort {
    public static void main(String args[]) {
        int[] array = new int[] {6,5,4,3,2,1};
        quickSort(array);
        for (int num: array) {
            System.out.println(num);
        }
    }

    public static int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        sort(array, left, right);
        return array;
    }
    private static void sort(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        int pivot = array[mid];
        int start = left;
        int end = right;

        while (start <= end) {
            while (start <= end && array[start] < pivot) {
                start++;
            }

            while (start <= end && array[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(array, start++, end--);
            }
        }
        sort(array, left, end);
        sort(array, start, right);
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}

/*
Given an array of integers, sort the elements in the array in ascending order.
 The quick sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
*/