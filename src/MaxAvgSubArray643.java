/**
 * tags: #slide-window
 */
public class MaxAvgSubArray643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAvg = -Double.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    sum += nums[j];
                }
            } else {
                sum += nums[i + k - 1] - nums[i - 1];
            }
            maxAvg = Math.max(sum / (double) k, maxAvg);
        }

        return maxAvg;
    }
}
