package array;

import java.util.Arrays;

/**
 * 56. Merge Intervals
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int cur = 0;
        for (int i = 1; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            int[] curInterval = res[cur];
            if (curInterval[1] < interval[0]) {
                res[++cur] = interval;
            } else {
                curInterval[0] = curInterval[0] < interval[0] ? curInterval[0] : interval[0];
                curInterval[1] = curInterval[1] > interval[1] ? curInterval[1] : interval[1];
            }
        }
        return Arrays.copyOfRange(res, 0, cur + 1);
    }
}
