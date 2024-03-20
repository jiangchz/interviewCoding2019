package leetcode.sortingAlgorithms.mergesort;

public class MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start1 = m - 1;
        int start2 = n - 1;
        int resultIndex = m + n - 1;
        while (resultIndex >= 0) {
            int num1 = start1 < 0 ? Integer.MIN_VALUE : nums1[start1];
            int num2 = start2 < 0 ? Integer.MIN_VALUE : nums2[start2];
            if (num1 >= num2) {
                nums1[resultIndex--] = nums1[start1--];
            } else {
                nums1[resultIndex--] = nums2[start2--];
            }
        }
    }
}

/*
lc: 88. Merge Sorted Array
 */
