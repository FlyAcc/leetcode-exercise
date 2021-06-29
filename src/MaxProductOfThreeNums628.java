import java.util.Arrays;

/**
 * tags: #Array, #Sorting
 */
public class MaxProductOfThreeNums628 {
    public int maximumProduct_Sorting(int[] nums) {
        Arrays.sort(nums);
        int end = nums.length - 1;
        return Math.max(nums[end] * nums[end - 1] * nums[end - 2], nums[0] * nums[1] * nums[end]);
    }

    /*
    由于最大积有两种情况：三个最大数相乘或者两个最小数和一个最大数相乘，
    因此我们只需找出这五个数，无需排序（比较慢）
     */
    public int maximumProduct_OnePass(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
