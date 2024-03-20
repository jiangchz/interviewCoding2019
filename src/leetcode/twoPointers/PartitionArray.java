package leetcode.twoPointers;

public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] < k) {
                left++;
                continue;
            }
            if (nums[right] >= k) {
                right--;
                continue;
            }
            swap(nums, left++, right--);
        }
        return left;
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
