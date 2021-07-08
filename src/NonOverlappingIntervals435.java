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
        int[] last = intervals[0];
        int min = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < last[1]) {
                min++;
                if (last[1] > interval[1]) {
                    last = interval;
                }
            } else {
                last = interval;
            }
        }

        return min;
    }
}
