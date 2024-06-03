package leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_LC56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] current : intervals) {
            int currentStart = current[0];
            int currentEnd = current[1];

            if (currentStart > end) {
                result.add(new int[] {start, end});
                start = currentStart;
                end = currentEnd;
            } else {
                end = Math.max(end, currentEnd);
            }
        }
        result.add(new int[] {start, end});

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
