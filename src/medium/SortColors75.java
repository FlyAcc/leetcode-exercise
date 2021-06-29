package medium;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors75 sc = new SortColors75();
        sc.sortColors_Brutal(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors_Brutal(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int min = 2;
        int max = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int minCount = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == min) {
                minCount++;
            } else if (num == max) {
                maxCount++;
            }
        }

        while (minCount > 0 || maxCount > 0) {

        }
    }
}
