package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection_LC986 {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();

        while(i < first.length && j < second.length) {
            int start1 =  first[i][0];
            int end1 = first[i][1];
            int start2 = second[j][0];
            int end2 = second[j][1];

            int startMax = Math.max(start1, start2);
            int endMin = Math.min(end1, end2);

            if (startMax <= endMin) {
                res.add(new int[] {startMax, endMin});
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }

        }
        int[][] resArray = new int[res.size()][2];
        return res.toArray(resArray);
    }
}
