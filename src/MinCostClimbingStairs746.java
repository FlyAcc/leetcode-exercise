/**
 * DP = 递归 + 记录（复用上一步的结果）
 * 1. Top-Down：使用递归
 * 2. Bottom-Up：使用数组
 * tags: #DP
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] min = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            min[i] = Math.min(min[i - 1] + cost[i - 1], min[i - 2] + cost[i - 2]);
        }

        return min[n];
    }

    /*
    bottom up可以使用以下方法优化：将O（n）的空间复杂度降为O（1）
    基本的思路是：当前的结果和上两步的结果相关（此题是能够爬1或2阶楼梯），因此我们只需记录这两个结果，
    每次循环我们更新这两个值，无需记录所有结果
     */
    public int minCostClimbingStairs_BottomUpOptimization(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2) return Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
