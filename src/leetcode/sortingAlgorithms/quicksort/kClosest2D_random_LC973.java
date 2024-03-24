package leetcode.sortingAlgorithms.quicksort;

import java.util.Arrays;
import java.util.Random;

public class kClosest2D_random_LC973 {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(0, points.length - 1, k - 1, points);
        return Arrays.copyOfRange(points,0, k);
    }

    private void quickSelect(int start, int end, int target, int[][] points) {
        if (start == end) {
            return;
        }


        while (start <= end) {
            int pIndex = new Random().nextInt(end - start + 1) + start;
            int pValue = points[pIndex][0] * points[pIndex][0] + points[pIndex][1] * points[pIndex][1];
            int mid = start;
            swap(pIndex, start, points);
            for (int i = start + 1; i <= end; i++) {
                if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pValue) {
                    swap(i, ++mid, points);
                }
            }
            swap(start, mid, points);

            if (mid == target) {
                return;
            } else if (mid > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }


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

    private static void swap(int index1, int index2, int[][] points) {
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
