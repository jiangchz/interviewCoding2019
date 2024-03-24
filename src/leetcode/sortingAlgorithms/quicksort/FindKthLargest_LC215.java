package leetcode.sortingAlgorithms.quicksort;

public class FindKthLargest_LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums.length - k, nums);
    }

    private static int quickSelect(int start, int end, int target, int[] numbers) {
        if (start == end){
            return numbers[start];
        }

        int pIndex = (end - start + 1)/2 + start;
        //        int pIndex = new Random().nextInt(end - start + 1) + start;
        pIndex = partition(start, end, pIndex, numbers);
        if (pIndex == target) {
            return numbers[pIndex];
        } else if (pIndex > target) {
            return quickSelect(start, pIndex - 1, target, numbers);
        } else {
            return quickSelect(pIndex + 1, end, target, numbers);
        }
    }
    private static int partition(int start, int end, int pivotIndex, int[] numbers) {
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, end);
        pivotIndex = end--;

        while (start <= end) {
            if (numbers[start] < pivot) {
                start++;
            } else if (numbers[end] > pivot) {
                end--;
            } else {
                swap(numbers, start++, end--);
            }
        }
        swap(numbers, start, pivotIndex);
        return start;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
