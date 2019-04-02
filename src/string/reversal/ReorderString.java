package string.reversal;

public class ReorderString {
    public static int[] reorder(int[] array) {
        if (array.length % 2 != 0) {
            reorderArray(array, 0, array.length - 2);//bug!
        } else {
            reorderArray(array, 0, array.length - 1);
        }
        return array;
    }

    private static void reorderArray(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }
        int mid =  left + size/2;
        int leftMid = left + size/4;
        int rightMid =left +  size / 4 * 3; // key feature
        reverseForRange(array, leftMid, mid - 1);
        reverseForRange(array, mid, rightMid -1);
        reverseForRange(array, leftMid, rightMid - 1);
        reorderArray(array, left, left + (leftMid - left) * 2 - 1); //bug  && key feature to keep chunk 1 == chunk3
        reorderArray(array, left + (leftMid - left) * 2, right); //bug
    }

    private static void reverseForRange(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left++] = array[right];
sw        }
    }

    public static void main(String args[]) {
        int[] test = {1,2,3,4,5,6,7,8};
        test = reorder(test);
        for (int num : test) {
            System.out.println(num);

        }
    }
}


/*
Given an array of elements, reorder it as follow:

{ N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

Try to do it in place.

Assumptions

The given array is not null
Examples

{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

{ 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }

{ 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }


 */