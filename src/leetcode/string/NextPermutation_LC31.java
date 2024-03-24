package leetcode.string;

public class NextPermutation_LC31 {
    public void nextPermutation(int[] nums) {
        int violateIndex = -1;

        //find next breaking point 
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i  + 1]) {
                violateIndex = i;
                break;
            }
        }

        //Not violation found
        if (violateIndex == -1) {
            reverse(nums, 0);
            return;
        }

        //find toswap violateIndex 
        for (int i = nums.length - 1; i > violateIndex; i--) {
            if (nums[i] > nums[violateIndex]) {
                swap(nums,violateIndex,i);
                reverse(nums, violateIndex + 1);
                return;
            }
        }
    }

    private void reverse(int[] nums, int start) {
        reverse(nums, start, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    
}
