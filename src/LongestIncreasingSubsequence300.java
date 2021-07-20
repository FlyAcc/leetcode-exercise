import java.util.Arrays;

/**
 * tags: #DP, #binary-search
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        LongestIncreasingSubsequence300 l = new LongestIncreasingSubsequence300();
        System.out.println(l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }

    public int lengthOfLIS_DP(int[] nums) {
        int l = nums.length;
        if (l < 2) {
            return l;
        }

        int longest = 1;
        int[] ls = new int[l];
        ls[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            ls[i] = 1;
            for (int j = i + 1; j < l; j++) {
                if (nums[i] < nums[j]) {
                    ls[i] = Math.max(ls[i], ls[j] + 1);
                }
            }
            longest = Math.max(longest, ls[i]);
        }

        return longest;
    }
}
