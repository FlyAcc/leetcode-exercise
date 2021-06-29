import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SummaryRanges228 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 10};
        SummaryRanges228 s = new SummaryRanges228();
        System.out.println(s.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return ranges;
        } else if (n == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }

        int start = 0;
        int curr = 0;
        while (curr < n - 1) {
            if (nums[curr] + 1 != nums[++curr]) {
                if (curr - start > 1) {
                    ranges.add(nums[start] + "->" + nums[curr - 1]);
                } else {
                    ranges.add(nums[start] + "");
                }

                start = curr;
            }

            if (curr == n - 1) {
                if (curr - start >= 1) {
                    ranges.add(nums[start] + "->" + nums[curr]);
                } else {
                    ranges.add(nums[start] + "");
                }
            }
        }

        return ranges;
    }
}
