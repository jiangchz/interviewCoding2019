package leetcode.binarySearch;

public class KClosestInSortedArray {
    public static int[] searchKClosestInSortedArray(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }

        int startIndexes[] = getStartIndex(array, target);
        return getKNumbersFromIndex(array, startIndexes, k, target);
    }

    private static int[] getStartIndex(final int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return new int[] {start, end};
    }

    private static int[] getKNumbersFromIndex(final int[] array, int[] startIndex, int k, int target) {
        int[] result = new int[k];
        int left = startIndex[0];
        int right = startIndex[1];
        int indexToFill = 0;


        while (left > 0 && right < array.length - 1 & indexToFill < k) {
            if (target - array[left] <= array[right] - target) {
                result[indexToFill++] = array[left--];
            } else {
                result[indexToFill++] = array[right++];
            }
        }

        while (indexToFill < k && left > 0) {
            result[indexToFill++] = array[left--];
        }

        while (indexToFill < k && right < array.length) {
            result[indexToFill++] = array[right++];
        }

        return result;
    }



    private static int[] getKNumbersFromIndexV2(final int[] array, int[] startIndex, int k, int target) {
        int start = startIndex[0];
        int end = startIndex[1];
        int[] result = new int[k];

        for (int index = 0; index < k; index++) {
            if (start < 0) {
                result[index] = array[end++];
                continue;
            }

            if (end > array.length - 1) {
                result[index] = array[start--];
                continue;
            }

            if (target - array[start] < array[end] - target) {
                result[index] = array[start--];
            } else {
                result[index] = array[end++];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] array = {1,5};
        int target = 10;
        int k = 2;
        int[] results = kClosest(array, target, k);
        for (int num : results) {
            System.out.println(num);
        }
    }


    // reversion on Feb 7th
    public static int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        }

        int startIndex = findClosestIndexToTarget(array, target);
        return getKClosestFromIndex(array, target,  k, startIndex);

    }

    private static int[] getKClosestFromIndex(int[] array, int target, int k, int startIndex) {
        int[] result = new int[k];
        int left = startIndex;
        int right = startIndex + 1;
        for (int index = 0; index < k; index++) {
            if (left < 0) {
                result[index] = array[right++];
                continue;

            }
            if (right > array.length - 1) {
                result[index] = array[left--];
                continue;
            }

            if (target - array[left] > array[right] - target) {
                result[index] = array[right++];
            } else {
                result[index] = array[left--];
            }
        }
        return result;
    }

    private static int findClosestIndexToTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return target - array[left] > array[right] - target ? right: left;
    }
}
/*
Given a target integer T, a non-negative integer K and an integer leetcode.array A sorted in ascending order,
find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer leetcode.array containing the K closest numbers(not indices) in A,
sorted in ascending order by the difference between the number and T.
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

*/