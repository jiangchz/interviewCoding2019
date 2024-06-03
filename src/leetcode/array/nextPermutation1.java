package leetcode.array;

import java.util.Arrays;
//ref： https://www.youtube.com/watch?v=w58KFpW5Pjk
public class nextPermutation1 {
    public void nextPermutation(int[] nums) {
        //scan from last to first find the first number smaller than it's right number
        //就是找到第一个比后面的数字小的数，也就是说通过replace这个index可以把整个数字变大
        int left = -1;
        int right = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                right = i;
                break;
            }
        }

        //如果整个数列是一个从右往左的降序排列的话，说明找不到这个replace的index，那么sort整个array
        if (left == -1) {
            reverse(nums, 0);
            return;
        }

        //找到target index后面的数字里面的最小的比target大的数
        //swap， 然后在sort target index后面的数
        for (int i = nums.length - 1; i > right; i--) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }

        swap(nums, left, right);
        reverse(nums, left + 1);
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
