package binarySearch;

public class LastOccurrence {
    public static int searchFirstOccurrence(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (array[end] == target) {
            return end;
        } else if (array[start] == target) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        int[] array = {1,2,3,7,7,7,7,7,7,7};
        int target = 7;
        System.out.println(searchFirstOccurrence(array, target));
    }
}
