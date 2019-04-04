package array;

import java.util.Arrays;
//ref： https://www.youtube.com/watch?v=w58KFpW5Pjk
public class nextPermutation1 {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        //scan from last to first find the first number smaller than it's right number
        //就是找到第一个比后面的数字小的数，也就是说通过replace这个index可以把整个数字变大
        int targetIndex = nums.length - 2;
        while (targetIndex >= 0) {
            if (nums[targetIndex] < nums[targetIndex + 1]) {
                break;
            }
            targetIndex--;
        }

        //如果整个数列是一个从右往左的降序排列的话，说明找不到这个replace的index，那么sort整个array
        if (targetIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        //找到target index后面的数字里面的最小的比target大的数
        //swap， 然后在sort target index后面的数
        int indexToReplace = targetIndex + 1;
        while (indexToReplace < length && nums[indexToReplace] > nums[targetIndex]) {
            indexToReplace++;
        }
        swap(nums, indexToReplace - 1, targetIndex);
        Arrays.sort(nums, targetIndex + 1, length);
    }
    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
