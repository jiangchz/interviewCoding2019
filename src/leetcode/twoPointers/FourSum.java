package leetcode.twoPointers;

import java.util.Arrays;

public class FourSum {
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            if (i != 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j != i + 1 && array[j] == array[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = array.length - 1;
                int currentTarget = target - array[i] - array[j];
                while (left < right) {
                    if (left != j + 1 && array[left] == array[left - 1]) {
                        continue;
                    }
                    if (array[left] + array[right] == currentTarget) {
                        return true;
                    }  else if (array[left] + array[right] > currentTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return false;
    }
}

