package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int[] array = new int[] {6,5,4,3,2,1};
        mergeSort(array);
    }

    //version 0, 递归当前层把底下传上来的处理好的数据给合并成结果
    public int[] mergeSort0(int[] array) {
        return mergeSortHelper(array, 0, array.length - 1);
    }
    public int[] mergeSortHelper(int[] array, int left, int right) {
        if (left > right) {
            return new int[]{};
        }
        if (left == right) {
            return new int[]{array[left]};
        }

        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSortHelper(array, left, mid);
        int[] rightResult = mergeSortHelper(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }
    private int[] merge(int[] left, int[] right) {
        int m = left.length;
        int n = right.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int[] result = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            int leftValue = leftIndex < m ? left[leftIndex] : Integer.MAX_VALUE;
            int rightValue = rightIndex < n ? right[rightIndex]: Integer.MAX_VALUE;
            if (leftValue < rightValue) {
                result[i] = left[leftIndex++];
            } else {
                result[i] = right[rightIndex++];
            }
        }
        return result;
    }

    //version 1 把结果递归的向下传，下层递归不需要向上返回值，而是修改参数的状态。
    //在merge的时候借助2个local 变量
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

    //version 2 把结果递归的向下传，下层递归不需要向上返回值，而是修改参数的状态。
    //在merge的时候借助上层传下来的helper array
    public static int[] mergeSort2(int[] array) {
        int[] temp = new int[array.length];
        mergeSortHelper2(array, temp, 0, array.length - 1);
        return array;
    }

    private static void mergeSortHelper2(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper2(array, temp, left, mid);
        mergeSortHelper2(array, temp, mid + 1, right);
        merge2(array, temp, left, mid, right);
    }

    private static void merge2(int[] array,
                       int[] temp,
                       int left,
                       int mid,
                       int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int resultIndex = left;
        while (leftIndex <= mid || rightIndex <= right) {
            int leftValue = leftIndex <= mid ? array[leftIndex] : Integer.MAX_VALUE;
            int rightValue = rightIndex <= right ? array[rightIndex] : Integer.MAX_VALUE;
            if (leftValue <= rightValue) {
                temp[resultIndex++] = array[leftIndex++];
            } else {
                temp[resultIndex++] = array[rightIndex++];
            }
        }

        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
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