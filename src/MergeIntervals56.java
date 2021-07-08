import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * tags: #sorting
 */
public class MergeIntervals56 {
    public static void main(String[] args) {
        MergeIntervals56 m = new MergeIntervals56();
        System.out.println(Arrays.deepToString(m.merge_Sorting(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int left = 0, right = 1;
        int start = intervals[left][0], end = intervals[left][1];
        while (right < intervals.length) {
            if (intervals[right][0] <= end && intervals[right][0] >= start) {
                end = Math.max(end, intervals[right][1]);
            } else {
                result.add(new int[]{start, end});
                left = right;
                start = intervals[left][0];
                end = intervals[left][1];
            }

            if (right == intervals.length - 1) {
                result.add(new int[]{start, end});
            }
            right++;
        }

        return result.toArray(new int[0][]);
    }

    public int[][] merge_Sorting(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] lastInterval = intervals[0];
        merged.add(lastInterval);
        for (int[] interval : intervals) {
            if (lastInterval[1] < interval[0]) {
                lastInterval = interval;
                merged.add(interval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
