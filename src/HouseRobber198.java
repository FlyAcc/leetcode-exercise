/**
 * https://leetcode.com/problems/house-robber/
 * 该题目标实际是：给出一个数组，找出数组元素和最大的组合，要求不能有相邻的元素
 * 考虑到:max(i) = Max(max(i-1), max(i-2)+nums[i]), 这是一个典型的动态规划问题
 * tags: #DP
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        // maxAmount2 -> max(i-1), maxAmount1 -> max(i-2)
        int maxAmount1 = 0, maxAmount2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxAmount2;
            maxAmount2 = maxAmount1 + nums[i]; // nums[i]>0
            maxAmount1 = Math.max(temp, maxAmount1); // 注意，我们始终取最大值
        }

        return Math.max(maxAmount1, maxAmount2);
    }
}
