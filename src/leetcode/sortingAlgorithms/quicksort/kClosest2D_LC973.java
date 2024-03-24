package leetcode.sortingAlgorithms.quicksort;

import java.util.Arrays;

public class kClosest2D_LC973 {
    public int[][] kClosest(int[][] points, int k) {
        int start = 0;
        int end = points.length - 1;

        while (start <= end) {
            int mid = partition(start, end, points);
            if (mid == k) {
                break;
            } else if (mid > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return Arrays.copyOfRange(points, 0, k);
    }


    private int partition(int start, int end, int[][] points) {
        int pIndex = start;
        int pValue = points[pIndex][0] * points[pIndex][0] + points[pIndex][1] * points[pIndex][1];

        for (int i = start + 1; i <= end; i++) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pValue) {
                swap(i, ++start, points);
            }
        }
        swap(start, pIndex, points);
        return start;
    }

    private void swap(int index1, int index2, int[][] points) {
        if (index1 == index2) {
            return;
        }
        int temp1 = points[index1][0];
        int temp2 = points[index1][1];
        points[index1][0] = points[index2][0];
        points[index1][1] = points[index2][1];
        points[index2][0] = temp1;
        points[index2][1] = temp2;
    }

}
