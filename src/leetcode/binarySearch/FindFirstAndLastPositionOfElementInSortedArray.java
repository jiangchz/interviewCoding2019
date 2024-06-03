package leetcode.binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int startIndex = -1;
        //find first target
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        //post-processing for find first target
        if (nums[left] == target) {
            startIndex = left;
        } else if (nums[right] == target) {
            startIndex = right;
        } else {
            return new int[]{startIndex, startIndex};
        }

        //find last target
        left = startIndex;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int endIndex = -1;
        //post-processing for find last target
        if (nums[right] == target) {
            endIndex = right;
        } else {
            endIndex = left;
        }

        return new int[]{startIndex, endIndex};
    }
}
