package leetcode.binarySearch;

public class SearchInSortedMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] > target) {
                right = mid;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid;
            } else {
                return true;
            }
        }
        return matrix[left / n][left % n] == target || matrix[right / n][right % n] == target;
    }

    public static void main(String args[]) {
        int[] numbers1 = {1,2,3};
        int[] numbers2 = {4,5,6};
        int[] numbers3 = {7,8,9};
        int[][] matrix = {numbers1,numbers2, numbers3};
        int target = 7;

        boolean result = searchMatrix(matrix, target);

        System.out.println(result);
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