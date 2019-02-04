package binarySearch;

public class ClassicBinarySearch {
    public int binarySearch(int[] array, int target) {
        //九章版本，缩小搜索空间到只有2个数字
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) {
                end = mid;
            } else if (array[mid] > target) {
                start = mid;
            } else {
                return mid;
            }
        }

        if (array[start] == target) {
            return start;
        } else if (array[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public int binarySearchV2(int[] array, int target) {
        // laioffer版本
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
