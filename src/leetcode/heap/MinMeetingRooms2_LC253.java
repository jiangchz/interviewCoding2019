package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms2_LC253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((interval1, interval2) -> interval1[1] - interval2[1]);

        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.add(interval);
                continue;
            }

            int[] current = pq.poll();
            if (current[1] <= interval[0]) {
                current[1] = interval[1];
            } else {
                pq.add(interval);
            }
            pq.add(current);
        }
        return pq.size();
    }
}

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
