package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> result = new ArrayList<>();

        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && a[i] == c[k]) {
                result.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

    public List<Integer> common2(int[] a, int[] b, int[] c) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        int pA = 0, pB = 0, pC = 0;
        while (pA < a.length && pB < b.length && pC < c.length) {
            if (a[pA] < b[pB]) {
                pA ++;
            } else if (b[pB] < c[pC]) {
                pB ++;
            } else if (b[pB] > c[pC]) {
                pC ++;
            } else {
                result.add(a[pA]);
                pA ++;
                pB ++;
                pC ++;
            }
        }
        return result;
    }
}
