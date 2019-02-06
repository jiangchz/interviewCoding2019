package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int[] array = new int[] {6,5,4,3,2,1};
        mergeSort(array);
    }

    public static int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        sort(array, left, right);
        return array;
    }
    private static void sort(int arr[], int left, int right)
    {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;

        sort(arr, left, middle);
        sort(arr , middle + 1, right);

        merge(arr, left, middle, right);
    }

    private static void merge(int array[], int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int leftIndex = 0;
        int rightIndex = 0;
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);


        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] > rightArray[rightIndex]) {
                array[left++] = rightArray[rightIndex++];
            } else {
                array[left++] = leftArray[leftIndex++];
            }
        }

        while (leftIndex < leftSize) {
            array[left++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightSize) {
            array[left++] = rightArray[rightIndex++];
        }
    }

}

/*
Given an array of integers, sort the elements in the array in ascending order.
The merge sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.

坑： Array.copyOfRange end index is exclusive!

*/