package array.easy;

import java.util.Arrays;

/**
 * @author Chen Jiongyu
 */
public class MoveZeros283 {
    public static void main(String[] args) {
        MoveZeros283 moveZeros283 = new MoveZeros283();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                // 将一元素移动到零元素的位置后，将该元素置零，即相当于交换两个元素
                if (i != j - 1) {
                    nums[i] = 0;
                }
            }
        }
    }
}
