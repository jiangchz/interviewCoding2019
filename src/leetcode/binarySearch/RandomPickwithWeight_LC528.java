package leetcode.binarySearch;

import java.util.Random;

public class RandomPickwithWeight_LC528 {
    int[] positions;
    public void Solution(int[] w) {
        positions = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            positions[i] = sum;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(positions[positions.length - 1]) + 1;
        int start = 0;
        int end = positions.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (positions[mid] == target) {
                return mid;
            } else if (positions[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
