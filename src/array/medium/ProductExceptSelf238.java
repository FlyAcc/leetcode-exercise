package array.medium;

import java.util.Arrays;

public class ProductExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductExceptSelf238 pes = new ProductExceptSelf238();
        System.out.println(Arrays.toString(pes.productExceptSelf(nums)));
        System.out.println(Arrays.toString(pes.productExceptSelf_TwoDirection(nums)));
        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(pes.productExceptSelf(nums)));
        System.out.println(Arrays.toString(pes.productExceptSelf_TwoDirection(nums)));
    }

    /*
    我的思路是：求出所有元素的积，然后除以该元素。但这样有个问题，元素值可能为0，无法使用除法。
    因此我算出所有非零元素的积，如果没有元素为0，那么结果为productOfNoneZeroElements / nums[i]；
    如果有非零元素，那么其余结果均为0，且仅当非零元素个数为1时，非零元素对应的结果为所有非零元素的积。
    显然，这么做比较复杂，多了很多不必要的判断
     */
    public int[] productExceptSelf(int[] nums) {
        int productOfNoneZeroElements = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                productOfNoneZeroElements *= num;
            }
        }

        int[] answers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                answers[i] = productOfNoneZeroElements / nums[i];
            } else if (zeroCount == 1 && nums[i] == 0) {
                answers[i] = productOfNoneZeroElements;
            }
        }

        return answers;
    }

    /*
    上面的做法用了除法，现在考虑下乘法。由于productExceptSelf=productLeft*productRight，
    所以我们可以使用两次循环，左右两个方向累乘得到结果
     */
    public int[] productExceptSelf_TwoDirection(int[] nums) {
        int[] answers = new int[nums.length];
        int tempProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            answers[i] = tempProduct;
            tempProduct *= nums[i];
        }

        tempProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answers[i] *= tempProduct;
            tempProduct *= nums[i];
        }

        return answers;
    }
}
