package leetcode.binarySearch;

public class SearchInSortedMatrix1 {
    public static int[] binarySearchInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {-1, -1};
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid/column][mid%column] < target) {
                start = mid + 1;
            } else if (matrix[mid/column][mid%column] > target) {
                end = mid - 1;
            } else {
                return new int[] {mid / column, mid % column};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String args[]) {
        int[] numbers1 = {1,2,3};
        int[] numbers2 = {4,5,6};
        int[] numbers3 = {7,8,9};
        int[][] matrix = {numbers1,numbers2, numbers3};
        int target = 7;

        int[] result = binarySearchInMatrix(matrix, target);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
/*
    The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
        Examples:

        matrix = { {1, 2, 3},
                   {4, 5, 7},
                   {8, 9, 10} }
        target = 7, return {1, 2}
        target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
*/