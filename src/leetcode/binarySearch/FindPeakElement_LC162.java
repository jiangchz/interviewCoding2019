package leetcode.binarySearch;

public class FindPeakElement_LC162 {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}
