/**
 * tags:
 */
public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 p = new PartitionEqualSubsetSum416();
        System.out.println(p.canPartition_Memo(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                99, 1}));
    }

    public boolean canPartition_Memo(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        dp_Memo(nums, 0, sum, dp);
        return dp[sum];
    }

    private void dp_Memo(int[] nums, int curr, int sum, boolean[] dp) {
        if (curr == nums.length) {
            return;
        }

        if (sum < nums[curr]) {
            dp_Memo(nums, curr + 1, sum, dp);
            return;
        }

        if (dp[sum - nums[curr]]) {
            return;
        }

        dp_Memo(nums, curr + 1, sum - nums[curr], dp);
        dp_Memo(nums, curr + 1, sum, dp);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
                if (j == sum && dp[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
    TLE
     */
    public boolean canPartition_Backtracking(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return backtracking(nums, 0, sum / 2);
    }

    private boolean backtracking(int[] nums, int curr, int remain) {
        if (remain < 0) {
            return false;
        }

        if (remain == 0) {
            return true;
        }

        for (int i = curr; i >= 0; i--) {
            if (backtracking(nums, i - 1, remain - nums[i])) {
                return true;
            }
        }

        return false;
    }
}
