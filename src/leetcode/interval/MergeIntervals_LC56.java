package leetcode.interval;

import java.util.Arrays;

public class MergeIntervals_LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> (interval1[0] - interval2[0]));
        int start = -1;
        int end = -1;
        int count = 0;

        for (int[] interval : intervals) {
            //case1: Not assigned
            if (start == -1) {
                start = interval[0];
                end = interval[1];
            } else {
                //case2: merge
                if (end >= interval[0]) {
                    end = Math.max(end, interval[1]);
                } else {
                    //case3: Not able to merge, save result;
                    intervals[count][0] = start;
                    intervals[count][1] = end;
                    count++;
                    start = interval[0];
                    end = interval[1];
                }
            }
        }

        //save the last internval
        if (start != -1) {
            intervals[count][0] = start;
            intervals[count][1] = end;
            count++;
        }

        //copy result
        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i] = intervals[i];
        }
        return result;
    }
}
