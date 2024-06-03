package leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        //Add all the intervals smaller than new
        while (index < intervals.length && intervals[index][1] < newStart) {
            result.add(intervals[index++]);
        }

        //merge overlapped intervlas
        while (index < intervals.length && intervals[index][0] <= newEnd) {
            newStart = Math.min(intervals[index][0], newStart);
            newEnd = Math.max(intervals[index][1], newEnd);
            index++;
        }

        result.add(new int[] {newStart, newEnd});

        while (index < intervals.length) {
            result.add(intervals[index++]);
        }

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 *
 */
