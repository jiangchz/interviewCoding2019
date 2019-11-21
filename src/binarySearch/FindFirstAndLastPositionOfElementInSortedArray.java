package binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        } else if (nums[right] == target) {
            result[0] = right;
        }

        if (result[0] == -1) {
            return result;
        }
        //注意 [1] 或者[2, 2]的情况
        for (int i = result[0]; i < nums.length + 1; i++) {
            if (i == nums.length || nums[i] != target) {
                result[1] = i - 1;
                break;
            }
        }
        return result;
    }
}
