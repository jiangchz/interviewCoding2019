package binarySearch;

public class ClosestInSortedArray {
    public static int searchClosestInArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) {
                start = mid;
            } else if (array[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return (array[end] - target) > (target - array[start]) ?
                start : end;
    }

    public static void main(String args[]) {
        int[] numbers1 = {1, 4, 6};
        int target = 3;
        System.out.println(searchClosestInArray(numbers1, target));
    }
}

/*
Given a target integer T and an integer array A sorted in ascending order,
find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
*/