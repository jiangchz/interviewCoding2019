package leetcode.sortingAlgorithms;

import java.util.List;

public class bucketSort {
    public int percentile95(List<Integer> lengths) {
        int[] counter = new int[4096];
        for (int length : lengths) {
            counter[length - 1]++;
        }
        int total = lengths.size();
        int result = 0;
        int index = 0;
        while (result < total * 0.95) {
            result += counter[index++];
        }
        return index;
    }
}


/*
Description
Given a list of integers representing the lengths of urls,
 find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

Assumptions

The maximum length of valid url is 4096

The list is not null and is not empty and does not contain null

Examples

[1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
 */