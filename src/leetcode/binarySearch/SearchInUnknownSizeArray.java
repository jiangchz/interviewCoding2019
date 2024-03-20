package leetcode.binarySearch;

public class SearchInUnknownSizeArray {
    public static int searchUnknownSizeArray(Dictionary dic, int target) {
        if (dic == null) {
            return -1;
        }

        int start = 0;
        int end = 10;
        while (dic.get(end) != -1) {
            end *= 10;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dic.get(mid) > target || dic.get(mid) == -1) {
                end = mid - 1;
            } else if (dic.get(mid) < target) {
                start = mid + 1;
            } else {
                return dic.get(mid);
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int target = 7;
        Dictionary dic = new Dictionary();
        System.out.println(searchUnknownSizeArray(dic, target));
    }

    private static class Dictionary{
        private int[] numbers = new int[] {1, 2,3,4,5,6,7, 8, 9 , 10, 11, 12, 13};
        public int get(int index) {
            if (index > numbers.length - 1) {
                return -1;
            }
            return numbers[index];
        }
    }
}

/*
Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
 determine if a given target integer T is in the dictionary.
 Return the index of T in A, return -1 if T is not in A.

Assumptions

dictionary A is not null
dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
Examples

A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

 */
