package array.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * tags:#DAC, #DP
 */
public class MaxSubarray53 {
    public static void main(String[] args) {
        MaxSubarray53 maxSubarray = new MaxSubarray53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarray.maxSubArray(nums));
        System.out.println(maxSubarray.maxSubArray_BottomUpDp(nums));
        System.out.println(maxSubarray.maxSubArray_MemoizeDp(nums));
        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubarray.maxSubArray_MemoizeDp(nums));
    }

    /*
    subProblem：每一部分的最大值
    一个部分的最大值为max（前一部分，当前元素与前一部分之和），不难发现后面的结果依赖于前面部分的计算结果，
    可以使用递归的方式解决，因而我们使用dp来优化，这里使用bottom up的方式更为方便
     */
    public int maxSubArray_BottomUpDp(int[] nums) {
        int currMax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    // 开箱装箱等操作耗费了很多时间
    public int maxSubArray_MemoizeDp(int[] nums) {
        Integer[] mem = new Integer[nums.length];
        mem[0] = nums[0];
        memoizeDp(nums, nums.length - 1, mem);
        return Arrays.stream(mem).max(Comparator.comparingInt(value -> value)).get();
    }

    public int memoizeDp(int[] nums, int last, Integer[] mem) {
        if (mem[last] != null) {
            return mem[last];
        }

        mem[last - 1] = memoizeDp(nums, last - 1, mem);
        mem[last] = Math.max(nums[last], mem[last - 1] + nums[last]);
        return mem[last];
    }

    public int maxSubArray(int[] nums) {
        return maxSumOfSubArray(nums, 0, nums.length - 1);
    }

    /*
    思路：若将数组划分到只有一个元素，那么显而易见该元素的值即为最大和。按照这种思路，我们可以分别求出左半部分和右半部分的
    最大值，然后将两部分合并（combine）。关键在于如何合并，一个子数组和最大可能有三种情况：
    1. 左半部分和最大
    2. 右半部分和最大
    3. 中间部分和最大
    其中，左半部分、右半部分和已经求出，所以合并的时候我们需要求的只有中间部分的和
     */
    public int maxSumOfSubArray(int[] A, int left, int right) {
        // can not be split
        if (left == right) {
            return A[left];
        }
        // split
        int mid = left + (right - left) / 2;
        // apply divide-and-conquer
        int leftSum = maxSumOfSubArray(A, left, mid);
        int rightSum = maxSumOfSubArray(A, mid + 1, right);
        // combine
        int crossSum = midSumOfSubArray(A, left, right);
        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    // 求子数组中间部分的（最大）和
    public int midSumOfSubArray(int[] A, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        // 关键是从中间开始
        for (int i = mid; i >= left; i--) {
            sum = sum + A[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum = sum + A[j];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
