import java.util.Arrays;
import java.util.Comparator;

/**
 * tags: #sorting
 */
public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int end = intervals[0][1];
        int min = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < end) {
                min++;
                end = Math.max(end, interval[1]);
            } else {
                end = interval[1];
            }
        }

        return min;
    }
}
