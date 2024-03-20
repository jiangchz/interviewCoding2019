package leetcode.sortingAlgorithms.mergesort;

public class MergeSort {
    public static void main(String args[]) {
        int[] array = new int[] {6,5,4,3,2,1};
        mergeSort(array);
    }

    //把结果递归的向下传，下层递归不需要向上返回值，而是修改参数的状态。
    //在merge的时候借助上层传下来的helper leetcode.array
    public static int[] mergeSort(int[] array) {
        //allocate helper leetcode.array to help merge step so we can guarantee o(n) space is used
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
Given an leetcode.array of integers, sort the elements in the leetcode.array in ascending order.
The merge sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases

What if the given leetcode.array is null? In this case, we do not need to do anything.
What if the given leetcode.array is of length zero? In this case, we do not need to do anything.

坑： Array.copyOfRange end index is exclusive!

*/