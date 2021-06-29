package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum15 ts = new ThreeSum15();
        System.out.println(ts.threeSum(nums));
        nums = new int[]{0, 0, 0, 0};
        System.out.println(ts.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int remain = -nums[i];
            if (remain < 0) {
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == remain) {
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum > remain) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
