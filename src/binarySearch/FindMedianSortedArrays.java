package binarySearch;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        //注意初始条件的控制 k代表第k小的数
        if (size % 2 == 0) {
            return (findMedianHelper(nums1, 0, nums2, 0, size / 2) + findMedianHelper(nums1, 0, nums2, 0, size / 2 + 1)) / 2.0;
        }
        return  findMedianHelper(nums1, 0, nums2, 0, size / 2  + 1);
    }
    private double findMedianHelper(int[] nums1, int left1, int[] nums2, int left2, int k) {
        //3 base cases
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int mid1 = left1 + k / 2 - 1;
        int mid2 = left2 + k / 2 - 1;
        int midValue1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int midValue2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        if (midValue1 >= midValue2) {
            return findMedianHelper(nums1, left1, nums2, mid2 + 1, k - k/2);
        } else {
            return findMedianHelper(nums1, mid1 + 1, nums2, left2, k - k/2);
        }
    }
}
