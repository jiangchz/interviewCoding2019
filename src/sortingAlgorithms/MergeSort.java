package sortingAlgorithms;

public class SelectionSort {
    public int[] sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int outerIndex = 0; outerIndex < array.length - 1; outerIndex++) {
            int localMin = outerIndex;
            for (int innerIndex = outerIndex + 1; innerIndex < array.length; innerIndex++) {
                localMin = array[innerIndex] < array[localMin] ? innerIndex : localMin;
            }
            swap(array, localMin, outerIndex);
        }
        return array;

    }
    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}

/*
Given an array of integers, sort the elements in the array in ascending order.
The selection sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.

*/