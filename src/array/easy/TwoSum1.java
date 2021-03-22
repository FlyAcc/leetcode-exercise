package array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * tags:#HashMap
 * 需要多次循环遍历数组寻找某个元素的场合可以事先将数组存在map，简化时间复杂度
 */
public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 twoSum = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum1(nums, 9)));
        nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 6)));
    }

    // brute force
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 该循环实际上是在寻找和i元素合为target的元素，可以使用hashmap将o（n）改善为o（1）
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
